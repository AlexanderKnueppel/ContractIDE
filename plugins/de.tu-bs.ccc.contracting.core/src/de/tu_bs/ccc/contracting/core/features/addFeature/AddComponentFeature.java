package de.tu_bs.ccc.contracting.core.features.addFeature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
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

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.util.ColorConstants;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class AddComponentFeature extends AbstractAddFeature implements IAddFeature {

	public AddComponentFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}


	public boolean canAdd(IAddContext context) {
		// check if user wants to add a EClass
		if (context.getNewObject() instanceof Module) {
			// check if user wants to add to a diagram
			if (context.getTargetContainer() instanceof Diagram) {
				return true;
			}
			if (context.getTargetContainer() instanceof ContainerShape) {
				PictogramElement pict = context.getTargetContainer();
				EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
				return businessObjects.size() == 1 && (businessObjects.get(0) instanceof Compound || businessObjects.get(0) instanceof System);
			}
		}
		return false;
	}

	public PictogramElement add(IAddContext context) {
		Module addedClass = (Module) context.getNewObject();
		ContainerShape targetDiagram = context.getTargetContainer();

		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

		// define a default size for the shape
		final int width = context.getWidth() <= 50 ? 100 : context.getWidth();
		final int height = context.getHeight() <= 50 ? 50 : context.getHeight();
		IGaService gaService = Graphiti.getGaService();
		RoundedRectangle roundedRectangle; // need to access it later

		{
			// create and set graphics algorithm
			roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
			if (addedClass instanceof Component) {
				roundedRectangle.setForeground(manageColor(ColorConstants.DARK_BLUE));
				roundedRectangle.setBackground(manageColor(ColorConstants.LIGHT_BLUE));
			} else if (addedClass instanceof Compound) {
				roundedRectangle.setForeground(manageColor(ColorConstants.DARK_BLUE));
				roundedRectangle.setBackground(manageColor(ColorConstants.LIGHT_TURQUOISE));
			} else if (addedClass instanceof Abstract) {
				roundedRectangle.setForeground(manageColor(ColorConstants.DARK_GREY));
				roundedRectangle.setBackground(manageColor(ColorConstants.LIGHT_GREY));
			}
			roundedRectangle.setLineWidth(2);
			gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width, height);

			// if added Class has no resource we add it to the resource
			// of the diagram
			// in a real scenario the business model would have its own resource
			if (addedClass.eResource() == null) {
				getDiagram().eResource().getContents().add(addedClass);
			}
			// create link and wire it
			link(containerShape, addedClass);
		}

		// SHAPE WITH LINE
		{
			// create shape for line
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set graphics algorithm
			Polyline polyline = gaService.createPolyline(shape, new int[] { 0, 20, width, 20 });
			if (addedClass instanceof Component) {
				polyline.setForeground(manageColor(ColorConstants.DARK_BLUE));
			} else if (addedClass instanceof Compound) {
				polyline.setForeground(manageColor(ColorConstants.DARK_BLUE));
			} else if (addedClass instanceof Abstract) {
				polyline.setForeground(manageColor(ColorConstants.DARK_GREY));
			} else if (addedClass instanceof System) {
				polyline.setForeground(manageColor(ColorConstants.DARK_GREEN));
			}
			polyline.setLineWidth(2);
		}

		// SHAPE WITH TEXT
		{
			// create shape for text
			Shape shape = peCreateService.createShape(containerShape, false);

			// create and set text graphics algorithm
			Text text = gaService.createText(shape, addedClass.getName()+"   "+addedClass.getVersion());
			text.setForeground(manageColor(ColorConstants.BLACK));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			// vertical alignment has as default value "center"
			text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			gaService.setLocationAndSize(text, 0, 0, width, 20);

			// create link and wire it
			link(shape, addedClass);
		}
		peCreateService.createChopboxAnchor(containerShape);
		int i = addedClass.getPorts().size();
		int j = addedClass.getPorts().size();
		for (Ports element : addedClass.getPorts()) {
			AddContext a = new AddContext();
			a.setTargetContainer(containerShape);

			a.setX(containerShape.getGraphicsAlgorithm().getWidth() / 2);
			a.setY((containerShape.getGraphicsAlgorithm().getHeight() * i) / j);
			a.setSize(40, 40);
			i--;
			addGraphicalRepresentation(a, element);
		}
		i = addedClass.getContract().size();
		j = addedClass.getContract().size();
		if (addedClass.getModule()==null) {
			
		
		for (Contract element : addedClass.getContract()) {
			AddContext a = new AddContext();
			a.setTargetContainer(containerShape);

			a.setX(((containerShape.getGraphicsAlgorithm().getX()) * i) / j);
			a.setY(((containerShape.getGraphicsAlgorithm().getY()) * i) / j);
			a.setSize(40, 40);
			i--;
			addGraphicalRepresentation(a, element);
		}}
		return containerShape;
	}

}
