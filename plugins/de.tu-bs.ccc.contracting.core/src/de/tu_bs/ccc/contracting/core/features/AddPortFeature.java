package de.tu_bs.ccc.contracting.core.features;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Image;
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

			//shape for port name
			Shape shape = peCreateService.createShape(containerShape, false);
			String portName = addedClass.getName();
			Text text = gaService.createText(shape, portName);
			text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
			// vertical alignment has as default value "center"
			text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			
			//shape for type
			Shape shape2 = peCreateService.createShape(containerShape, false);
			Text text2 = gaService.createText(shape2, addedClass.getType().toString());
			text2.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
			// vertical alignment has as default value "center"
			text2.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
			
			//shape for signifier for input or output
			Shape shape3 = peCreateService.createShape(containerShape, false);
			Ellipse ellipse = gaService.createEllipse(shape3);
			
			if(signifier == "i") {
				gaService.setLocationAndSize(text, 25, 0, portWidth - 25, portHeight / 2);
				gaService.setLocationAndSize(text2, 25, portHeight / 2, portWidth, portHeight / 2);
				ellipse.setForeground(manageColor(IColorConstant.WHITE));
				ellipse.setBackground(manageColor(IColorConstant.GREEN));
				gaService.setLocationAndSize(ellipse, 2, portHeight / 2 - 9, 18, 18);
				Text text3 = gaService.createText(ellipse, "I");
				text3.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
				text3.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
				text3.setForeground(gaService.manageColor(getDiagram(), ColorConstant.BLACK));
				gaService.setLocationAndSize(text3, 0, 0, 18, 18);				
			} else if(signifier == "o") {
				gaService.setLocationAndSize(text, 10, 0, portWidth - 25, portHeight / 2);
				gaService.setLocationAndSize(text2, 10, portHeight / 2, portWidth, portHeight / 2);
				ellipse.setForeground(manageColor(IColorConstant.WHITE));
				ellipse.setBackground(manageColor(IColorConstant.RED));
				gaService.setLocationAndSize(ellipse, portWidth - 20, portHeight / 2 - 9, 18, 18);
				Text text3 = gaService.createText(ellipse, "O");
				text3.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
				text3.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
				text3.setForeground(gaService.manageColor(getDiagram(), ColorConstant.BLACK));
				gaService.setLocationAndSize(text3, 0, 0, 18, 18);
			}
			
			
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
		int heightContainer = (context.getTargetContainer().getGraphicsAlgorithm().getHeight());
		int[] coordinaten = new int[2];
		int calcPosX = context.getX();
		int calcPosY = context.getY();
		calcPosX = calcPosX - (widthContainer / 2);
		calcPosY = calcPosY - (heightContainer / 2);

			if (calcPosX < 0) {
				coordinaten[0] = 0;
				coordinaten[1] = context.getY();
				((Ports) context.getNewObject()).setOuterDirection(DirectionType.INTERNAL);
				signifier = "i";
				signifierColor = new ColorConstant(0, 100, 0);
			} else {
				coordinaten[0] = widthContainer - portWidth;
				coordinaten[1] = context.getY();
				((Ports) context.getNewObject()).setOuterDirection(DirectionType.EXTERNAL);
				signifier = "o";
				signifierColor = new ColorConstant(150, 0, 0);
			}
		return coordinaten;
	}

}
