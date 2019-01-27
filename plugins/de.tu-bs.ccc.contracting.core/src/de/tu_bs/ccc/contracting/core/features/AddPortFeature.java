package de.tu_bs.ccc.contracting.core.features;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;

import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class AddPortFeature extends AbstractAddFeature {
	private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(98, 131, 167);

	private static final IColorConstant E_CLASS_BACKGROUND = IColorConstant.WHITE;

	private IColorConstant signifierColor;
	
	private String signifier;
	
	public AddPortFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if (context.getNewObject() instanceof Ports) {
			// check if user wants to add to a diagram
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {
				return false;

			}
			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Module;
		}
		return true;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		int portWidth = 80;
		int portHeight = 40;
		int[] coordinaten = this.getPosition(context, portWidth, portHeight);
		int xCoordinate = coordinaten[0];
		int yCoordinate = coordinaten[1];

		Ports addedClass = (Ports) context.getNewObject();
		ContainerShape targetModule = context.getTargetContainer();

		// CONTAINER SHAPE WITH ROUNDED RECTANGLE
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(targetModule, true);

		IGaService gaService = Graphiti.getGaService();
		Rectangle roundedRectangle; // need to access it later

		{
			// create and set graphics algorithm
			roundedRectangle = gaService.createRectangle(containerShape);
			roundedRectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
			roundedRectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
			roundedRectangle.setLineWidth(2);

			gaService.setLocationAndSize(roundedRectangle, xCoordinate, yCoordinate, portWidth, portHeight);

			// Shape portShape = peCreateService.createShape(containerShape, false);
			// Image image = gaService.createImage(portShape,
			// ContractModellingImageProvider.IMG_PORT_INPUT);
			//
			// gaService.setLocationAndSize(image, 0, 0, portWidth
			// ,image.getHeight());

			Shape shape = peCreateService.createShape(containerShape, false);
			String portName = addedClass.getName();
			Text text = gaService.createText(shape, portName);
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			// vertical alignment has as default value "center"
			text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			gaService.setLocationAndSize(text, 0, 0, portWidth, (portHeight) / 2);
			
			Shape shape2 = peCreateService.createShape(containerShape, false);
			Text text2 = gaService.createText(shape2, addedClass.getType().toString());
			text2.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			// vertical alignment has as default value "center"
			text2.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			gaService.setLocationAndSize(text2, 0, portHeight / 2, portWidth, (portHeight) / 2);

			
			Shape shape3 = peCreateService.createShape(containerShape, false);
			Text text3 = gaService.createText(shape3, signifier);
			text3.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
			// vertical alignment has as default value "center"
			text3.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			text3.setForeground(gaService.manageColor(getDiagram(), signifierColor));
			gaService.setLocationAndSize(text3, 5, 0, 20, 20);
			
			// if added Class has no resource we add it to the resource
			// of the diagram
			// in a real scenario the business model would have its own resource
			// if (addedClass.eResource() == null) {
			// getDiagram().eResource().getContents().add(addedClass);
			// }

			// create link and wire it
			link(containerShape, addedClass);
		}
		peCreateService.createChopboxAnchor(containerShape);

		// call the layout feature
		layoutPictogramElement(containerShape);
		return containerShape;
	}

	int[] getPosition(IAddContext context, int portWidth, int portHeight) {
		int widthContainer = (context.getTargetContainer().getGraphicsAlgorithm().getWidth());
		int[] coordinaten = new int[2];
		
		if(((Ports) context.getNewObject()).getOuterDirection() == DirectionType.INTERNAL) {
			coordinaten[0] = 0;
			coordinaten[1] = context.getY();
			signifier = "i";
			signifierColor = new ColorConstant(0, 100, 0);
		} else {
			coordinaten[0] = widthContainer - portWidth;
			coordinaten[1] = context.getY();
			signifier = "e";
			signifierColor = new ColorConstant(150, 0, 0);
		}
		return coordinaten;
	}

}
