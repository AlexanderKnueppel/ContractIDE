package de.tu_bs.ccc.contracting.core.move;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.graphiti.mm.algorithms.Text;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.ui.dialogs.RemoveConnectionDialog;

public class MovePortFeature extends DefaultMoveShapeFeature {

	private boolean changeDirection = false;
	private String direction;
	private int[] coordinates = new int[2];

	public MovePortFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void postMoveShape(IMoveShapeContext context) {
		int width = context.getShape().getGraphicsAlgorithm().getWidth();
		int height = context.getShape().getGraphicsAlgorithm().getHeight();
		coordinates = getPosition(context, width, height);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		IGaService gaService = Graphiti.getGaService();
		if (changeDirection && checkConnection(context)) {
			if (RemoveConnectionDialog.removeConnectionDialog(shell, getPort(context).getName())) {
				deleteConnections(getPort(context), context);
				updateDirection(context, direction);
				gaService.setLocation(context.getShape().getGraphicsAlgorithm(), coordinates[0], coordinates[1]);
			} else {
				int oldXPos = direction.equals("external") ? 0
						: (context.getTargetContainer().getGraphicsAlgorithm().getWidth()) - width;
				gaService.setLocation(context.getShape().getGraphicsAlgorithm(), oldXPos, coordinates[1]);
			}
		} else {
			updateDirection(context, direction);
			gaService.setLocation(context.getShape().getGraphicsAlgorithm(), coordinates[0], coordinates[1]);
		}

	}

	private Ports getPort(IMoveShapeContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Ports) {
			return ((Ports) bo);
		}
		return null;
	}

	private int[] getPosition(IMoveShapeContext context, int portWidth, int portHeight) {
		int widthContainer = (context.getTargetContainer().getGraphicsAlgorithm().getWidth());
		int heightContainer = (context.getTargetContainer().getGraphicsAlgorithm().getHeight());
		int[] coordinates = new int[2];
		int calcPosX = context.getX();
		int calcPosY = context.getY();
		calcPosX = calcPosX - (widthContainer / 2);
		calcPosY = calcPosY - (heightContainer / 2);
		if (calcPosX < 0) {
			coordinates[0] = 0;
			coordinates[1] = context.getY();
			direction = "internal";
			changeDirection = getPort(context).getOuterDirection().equals(DirectionType.EXTERNAL);
		} else {
			coordinates[0] = widthContainer - portWidth;
			coordinates[1] = context.getY();
			direction = "external";
			changeDirection = getPort(context).getOuterDirection().equals(DirectionType.INTERNAL);
		}
		return coordinates;
	}

	private void updateDirection(IMoveShapeContext context, String direction) {
		PictogramElement pictogramElement = context.getPictogramElement();
		ContainerShape cs = (ContainerShape) pictogramElement;
		IGaService gaService = Graphiti.getGaService();
		int width = context.getShape().getGraphicsAlgorithm().getWidth();
		int height = context.getShape().getGraphicsAlgorithm().getHeight();
		if (direction.equals("internal")) {
			getPort(context).setOuterDirection(DirectionType.INTERNAL);
			((Text) cs.getChildren().get(2).getGraphicsAlgorithm().eContents().get(0)).setValue("I");
			gaService.setLocation(cs.getChildren().get(0).getGraphicsAlgorithm(), 25, 0);
			//gaService.setLocation(cs.getChildren().get(1).getGraphicsAlgorithm(), 25, height/2);
			gaService.setLocation(cs.getChildren().get(1).getGraphicsAlgorithm(), 25, 20);
			gaService.setLocation(cs.getChildren().get(2).getGraphicsAlgorithm(), 2, height / 2 - 9);
			cs.getChildren().get(2).getGraphicsAlgorithm().setBackground(manageColor(IColorConstant.GREEN));
		} else {
			getPort(context).setOuterDirection(DirectionType.EXTERNAL);
			((Text) cs.getChildren().get(2).getGraphicsAlgorithm().eContents().get(0)).setValue("O");
			gaService.setLocation(cs.getChildren().get(0).getGraphicsAlgorithm(), 10, 0);
			//gaService.setLocation(cs.getChildren().get(1).getGraphicsAlgorithm(), 10, height/2);
			gaService.setLocation(cs.getChildren().get(1).getGraphicsAlgorithm(), 10, 20);
			gaService.setLocation(cs.getChildren().get(2).getGraphicsAlgorithm(), width - 20, height / 2 - 9);
			cs.getChildren().get(2).getGraphicsAlgorithm().setBackground(manageColor(IColorConstant.RED));
		}
	}

	private boolean checkConnection(IMoveShapeContext context) {
		Shape shape = context.getShape();
		List<Anchor> list = getAnchorsOfPort(shape);
		for (Anchor a : list) {
			List<Connection> outConnections = a.getOutgoingConnections();
			List<Connection> inConnections = a.getIncomingConnections();

			if (outConnections.size() != 0 || inConnections.size() != 0) {
				return true;
			}
		}
		return false;
	}

	private void deleteConnections(Ports port, IMoveShapeContext context) {
		Shape shape = context.getShape();
		List<Anchor> list = getAnchorsOfPort(shape);

		for (Anchor a : list) {
			List<Connection> outConnections = a.getOutgoingConnections();
			List<Connection> inConnections = a.getIncomingConnections();

			if (outConnections.size() != 0) {
				removeConnection(outConnections);
			}

			if (inConnections.size() != 0) {
				removeConnection(inConnections);
			}
		}
	}

	private void removeConnection(List<Connection> connections) {
		List<PictogramElement> pictoList = new ArrayList<>();
		for (Connection c : connections) {
			Ports port1 = (Ports) getBusinessObjectForPictogramElement(c.getStart().getParent());
			Ports port2 = (Ports) getBusinessObjectForPictogramElement(c.getEnd().getParent());

			if (port1.getInsidePorts().contains(port2)) {
				port1.getInsidePorts().remove(port2);
				port2.setInsidePortseOpposite(null);
			} else if (port1.getInsidePortseOpposite() == port2) {
				port2.getInsidePorts().remove(port1);
				port1.setInsidePortseOpposite(null);
			} else if (port1.getPorts().contains(port2)) {
				port1.getPorts().remove(port2);
				port2.setPortseOpposite(null);
			} else if (port1.getPortseOpposite() == port2) {
				port2.getPorts().remove(port2);
				port1.setPortseOpposite(null);
			}
			pictoList.add(c);
		}

		Iterable<PictogramElement> pes = (Iterable<PictogramElement>) pictoList;
		Graphiti.getPeService().deletePictogramElementIgnoringCrossReferences(pes);
	}

	private List<Anchor> getAnchorsOfPort(Shape theShape) {
		List<Anchor> ret = new ArrayList<Anchor>();
		ret.addAll(theShape.getAnchors());

		if (theShape instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) theShape;
			List<Shape> children = containerShape.getChildren();
			for (Shape shape : children) {
				if (shape instanceof ContainerShape) {
					ret.addAll(getAnchorsOfPort((ContainerShape) shape));
				} else {
					ret.addAll(shape.getAnchors());
				}
			}
		}
		return ret;
	}
}
