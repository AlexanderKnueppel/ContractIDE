package de.tu_bs.ccc.contracting.core.resize;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class ResizePortFeature extends DefaultResizeShapeFeature {
	public ResizePortFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void resizeShape(IResizeShapeContext context) {
		Shape shape = context.getShape();
		int x = context.getX();
		int y = context.getY();
		int width = context.getWidth();
		int height = context.getHeight();
		IGaService gaService = Graphiti.getGaService();
		if (shape.getGraphicsAlgorithm() != null) {
			gaService.setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, width, height);
		}
		
		PictogramElement pictogramElement = context.getPictogramElement();
		Ports bo = (Ports) getBusinessObjectForPictogramElement(pictogramElement);
		ContainerShape cs = (ContainerShape) pictogramElement;
		if (bo.getOuterDirection().equals(DirectionType.EXTERNAL)) {
			Shape name = cs.getChildren().get(0);
			Text nameText = (Text) name.getGraphicsAlgorithm();
			nameText.setWidth(cs.getGraphicsAlgorithm().getWidth() - 25);
			gaService.setLocation(cs.getChildren().get(2).getGraphicsAlgorithm(), width - 20, height / 2 - 9);
		} else {
			gaService.setLocation(cs.getChildren().get(2).getGraphicsAlgorithm(), 2, height / 2 - 9);
		}
	}
}
