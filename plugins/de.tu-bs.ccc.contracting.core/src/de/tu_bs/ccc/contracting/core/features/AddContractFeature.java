package de.tu_bs.ccc.contracting.core.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.ContractType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;

public class AddContractFeature extends AbstractAddFeature implements IAddFeature {

	public AddContractFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	private static IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;

	private static IColorConstant E_CLASS_FORE = new ColorConstant(192, 40, 30);

	private static IColorConstant E_CLASS_BACK = new ColorConstant(240, 80, 60);

	public boolean canAdd(IAddContext context) {
		
		return true;
	}

	public PictogramElement add(IAddContext context) {

		Contract addedClass = (Contract) context.getNewObject();
		if (addedClass.getViewPoint().getValue() == ViewPoint.FUNCTIONAL_VALUE) {
			E_CLASS_FORE = new ColorConstant(192, 40, 30);

			E_CLASS_BACK = new ColorConstant(240, 80, 60);

		} else if (addedClass.getViewPoint().getValue() == ViewPoint.TIMING_VALUE) {
			E_CLASS_FORE = new ColorConstant(40, 192, 30);

			E_CLASS_BACK = new ColorConstant(80, 240, 60);

		} else {
		E_CLASS_FORE = new ColorConstant(30, 40, 192);

		E_CLASS_BACK = new ColorConstant(120, 190, 250);
		}
		ContainerShape targetDiagram = context.getTargetContainer().getContainer();

		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

		// define a default size for the shape
		final int width = context.getWidth() <= 100 ? 100 : context.getWidth();
		final int height = context.getHeight() <= 150 ? 150 : context.getHeight();
		IGaService gaService = Graphiti.getGaService();
		RoundedRectangle roundedRectangle; // need to access it later

		{
			// create and set graphics algorithm
			roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
			roundedRectangle.setForeground(manageColor(E_CLASS_FORE));
			roundedRectangle.setBackground(manageColor(E_CLASS_BACK));
			roundedRectangle.setLineWidth(2);
			gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width, height);

			// if added Class has no resource we add it to the resource
			// of the diagram
			// in a real scenario the business model would have its own resource
			// create link and wire it
			link(containerShape, addedClass);
		}

		// SHAPE WITH LINE
		{
			// create shape for line
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set graphics algorithm
			Polyline polyline = gaService.createPolyline(shape, new int[] { 0, 20, width + 50, 20 });
			polyline.setForeground(manageColor(E_CLASS_FORE));
			polyline.setLineWidth(2);
		}

		// SHAPE WITH TEXT
		{
			// create shape for text
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set text graphics algorithm
			Text text = gaService.createText(shape, addedClass.getViewPoint().getName());
			text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
			text.setBackground(manageColor(180, 180, 180));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			// vertical alignment has as default value "center"
			text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			gaService.setLocationAndSize(text, 0, 0, width, 20);

		}
		peCreateService.createChopboxAnchor(containerShape);
		updatePictogramElement(containerShape);
		
		
		AddConnectionContext a = new AddConnectionContext(containerShape.getAnchors().get(0), context.getTargetContainer().getAnchors().get(0));
		a.setTargetContainer(context.getTargetContainer().getContainer());
		getFeatureProvider().addIfPossible(a);
		
		return containerShape;

	}

}
