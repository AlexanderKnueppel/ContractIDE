package de.tu_bs.ccc.contracting.core.move;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.mm.algorithms.Text;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class MovePortFeature extends DefaultMoveShapeFeature {


	public MovePortFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void postMoveShape(IMoveShapeContext context) {
		int width = context.getShape().getGraphicsAlgorithm().getWidth();
		int height = context.getShape().getGraphicsAlgorithm().getHeight();
		IGaService gaService = Graphiti.getGaService();
		int[] coordinates = getPosition(context, width, height);
		gaService.setLocation(context.getShape().getGraphicsAlgorithm(), coordinates[0], coordinates[1]);
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
		int[] coordinaten = new int[2];
		int calcPosX = context.getX();
		int calcPosY = context.getY();
		calcPosX = calcPosX - (widthContainer / 2);
		calcPosY = calcPosY - (heightContainer / 2);
		if (calcPosX < 0) {
			coordinaten[0] = 0;
			coordinaten[1] = context.getY();
			updateDirection(context, "internal");
		} else {
			coordinaten[0] = widthContainer - portWidth;
			coordinaten[1] = context.getY();
			updateDirection(context, "external");
		}
		return coordinaten;
	}

	private void updateDirection(IMoveShapeContext context, String direction) {
		PictogramElement pictogramElement = context.getPictogramElement();
		ContainerShape cs = (ContainerShape) pictogramElement;
		IGaService gaService = Graphiti.getGaService();
		if(direction.equals("internal") ) {
			getPort(context).setOuterDirection(DirectionType.INTERNAL);
			((Text) cs.getChildren().get(2).getGraphicsAlgorithm()).setValue("i");
			((Text) cs.getChildren().get(2).getGraphicsAlgorithm()).setForeground(gaService.manageColor(getDiagram(), new ColorConstant(0, 100, 0)));
		} else {
			getPort(context).setOuterDirection(DirectionType.EXTERNAL);
			((Text) cs.getChildren().get(2).getGraphicsAlgorithm()).setValue("e");
			((Text) cs.getChildren().get(2).getGraphicsAlgorithm()).setForeground(gaService.manageColor(getDiagram(), new ColorConstant(150, 0, 0)));
		}
	}

}
