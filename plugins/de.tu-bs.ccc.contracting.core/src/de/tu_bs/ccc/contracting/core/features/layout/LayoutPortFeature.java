package de.tu_bs.ccc.contracting.core.features.layout;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.ui.services.IUiLayoutService;

import de.tu_bs.ccc.contracting.Verification.Ports;

public class LayoutPortFeature extends AbstractLayoutFeature implements ILayoutFeature {

	private static final int MIN_HEIGHT = 20;
	private static final int MIN_WIDTH = 30;

	public LayoutPortFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canLayout(ILayoutContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (!(pe instanceof ContainerShape))
			return false;

		return getBusinessObjectForPictogramElement(pe) instanceof Ports;
	}

	@Override
	public boolean layout(ILayoutContext context) {
		boolean anythingChanged = false;
		ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();

		// height
		if (containerGa.getHeight() < MIN_HEIGHT) {
			containerGa.setHeight(MIN_HEIGHT);
			anythingChanged = true;
		}

		// width
		if (containerGa.getWidth() < MIN_WIDTH) {
			containerGa.setWidth(MIN_WIDTH);
			anythingChanged = true;
		}

//		int containerWidth = containerGa.getWidth();
//		int containerHeight = containerGa.getHeight();
		for (Shape shape : containerShape.getChildren()) {
			GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
			IGaService gaService = Graphiti.getGaService();
			IDimension size = gaService.calculateSize(graphicsAlgorithm);
			
			if(graphicsAlgorithm instanceof Text) {
				IUiLayoutService uil = GraphitiUi.getUiLayoutService();
				size = uil.calculateTextSize(((Text)graphicsAlgorithm).getValue(), ((Text)graphicsAlgorithm).getFont());
				graphicsAlgorithm.setWidth(graphicsAlgorithm.getX() + size.getWidth());
			}
			
			
			if(graphicsAlgorithm.getX() + size.getWidth() > containerGa.getWidth()) 
				containerGa.setWidth(graphicsAlgorithm.getX() + size.getWidth());
			if(graphicsAlgorithm.getY() + size.getHeight() > containerGa.getHeight())
				containerGa.setHeight(graphicsAlgorithm.getY() + size.getHeight());
			
			anythingChanged = true;
			
		}

		return anythingChanged;
	}

}
