package de.tu_bs.ccc.contracting.core.features.resize;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.mm.pictograms.impl.ContainerShapeImpl;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class ResizeModuleFeature extends DefaultResizeShapeFeature {

	public ResizeModuleFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void resizeShape(IResizeShapeContext context) {
		Shape shape = context.getShape();
		int x = context.getX();
		int y = context.getY();
		int width = context.getWidth();
		int height = context.getHeight();
		if (shape.getGraphicsAlgorithm() != null) {
			Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, width, height);
		}
		layoutPictogramElement(shape);
		checkPorts(context);
	}

	private void checkPorts(IResizeShapeContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		ContainerShape cs = (ContainerShape) pictogramElement;
		for (Shape shape : cs.getChildren()) {
			if (shape instanceof ContainerShapeImpl) {
				PictogramElement pictogramPort = shape.getGraphicsAlgorithm().getPictogramElement();
				Object bo = getBusinessObjectForPictogramElement(pictogramPort);
				if (bo instanceof Ports) {
					Ports port = (Ports) bo;
					setNewPortPosition(context, shape, port);
				}
			}
		}
	}


	private void setNewPortPosition(IResizeShapeContext context, Shape portShape, Ports port) {
		IGaService gaService = Graphiti.getGaService();
		int moduleSizeX = context.getWidth();
		int portSizeX = portShape.getGraphicsAlgorithm().getWidth();
		int portLocX = portShape.getGraphicsAlgorithm().getX();
		int portLocY = portShape.getGraphicsAlgorithm().getY();
		if (port.getOuterDirection().equals(DirectionType.EXTERNAL)) {
			if (moduleSizeX != (portLocX + portSizeX)) {
				gaService.setLocation(portShape.getGraphicsAlgorithm(), moduleSizeX - portSizeX, portLocY);
			}

		}

	}

}
