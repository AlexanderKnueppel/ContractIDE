package de.tu_bs.ccc.contracting.core.guiFeatures;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

public class CompactLayoutFeature extends AbstractLayoutFeature {

	public CompactLayoutFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canLayout(ILayoutContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (!(pe instanceof ContainerShape))
			return false;
		return true;
	}

	@Override
	public boolean layout(ILayoutContext context) {
		boolean change = false;
		ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		GraphicsAlgorithm contGa = containerShape.getGraphicsAlgorithm();
		int containerWidth = contGa.getWidth();
		for (Shape shape : containerShape.getChildren()) {
			GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
			IGaService gaService = Graphiti.getGaService();
			IDimension size = gaService.calculateSize(graphicsAlgorithm);
			if (containerWidth != size.getWidth()) {
				if (graphicsAlgorithm instanceof Polyline) {
					Polyline polyline = (Polyline) graphicsAlgorithm;
					Point secondPoint = polyline.getPoints().get(1);
					Point newSecondPoint = gaService.createPoint(containerWidth, secondPoint.getY());
					polyline.getPoints().set(1, newSecondPoint);
					change = true;
				}
				else if (graphicsAlgorithm instanceof Text) {
					gaService.setWidth(graphicsAlgorithm, containerWidth/2);
					change = true;
				} 
				else if(true) {
					
				}
			

		}
		}
	        
		return false;
	}
}

