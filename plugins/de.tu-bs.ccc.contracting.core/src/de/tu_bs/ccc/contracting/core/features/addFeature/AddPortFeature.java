package de.tu_bs.ccc.contracting.core.features.addFeature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.ui.services.IUiLayoutService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.diagram.ContractModellingImageProvider;

public class AddPortFeature extends AbstractAddFeature {
	public static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(98, 131, 167);
	public static final IColorConstant E_CLASS_BACKGROUND = IColorConstant.WHITE;
	public static final IColorConstant TYPE_COLOR = IColorConstant.BLUE;
	public static final int PORT_MIN_WIDTH = 80;
	public static final int PORT_MIN_HEIGHT = 40;
	public static final int PORT_PADDING = 10;
	public static final int PORT_ICON_WIDTH = 15;
	public static final int PORT_ICON_HEIGHT = 15;

	// private IColorConstant signifierColor;
	private String imageID;

	// private String signifier;

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

			// Name + Service Type
			Shape shape = peCreateService.createShape(containerShape, false);
			String portName = addedClass.getName();
			String suffix = "";
			if (addedClass.getType().getValue() == PortType.SERVICE_VALUE) {
				suffix += " : " + addedClass.getService();
			}
			Text text = gaService.createText(shape, portName + suffix);
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			// vertical alignment has as default value "center"
			text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));

			// Port Type
			Shape shape2 = peCreateService.createShape(containerShape, false);
			Text text2 = gaService.createText(shape2, addedClass.getType().toString());
			text2.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			// vertical alignment has as default value "center"
			text2.setFont(gaService.manageDefaultFont(getDiagram(), true, true));
			text2.setForeground(gaService.manageColor(getDiagram(), TYPE_COLOR));

			// ---> Set locations and resize...
			IUiLayoutService uil = GraphitiUi.getUiLayoutService();
			IDimension size = uil.calculateTextSize(text.getValue(), text.getFont());
			int newPortWidth = Math.max(PORT_MIN_WIDTH, size.getWidth() + PORT_PADDING + PORT_ICON_WIDTH);

			// Port container
			int x = getPosition(context, newPortWidth, PORT_MIN_HEIGHT)[0],
					y = getPosition(context, newPortWidth, PORT_MIN_HEIGHT)[1];
			gaService.setLocationAndSize(roundedRectangle, x, y, newPortWidth, PORT_MIN_HEIGHT);

			// Port icon
			x = 0;
			y = (PORT_MIN_HEIGHT / 2) - (PORT_ICON_HEIGHT / 2);
			if (imageID.equals(ContractModellingImageProvider.IMG_PORT_OUTPUT))
				x = roundedRectangle.getWidth() - PORT_ICON_WIDTH;
			// Port icon
			Image imgSignifier = gaService.createImage(roundedRectangle, imageID);
			imgSignifier.setStretchH(true);
			imgSignifier.setStretchV(true);
			gaService.setLocationAndSize(imgSignifier, x, y, PORT_ICON_WIDTH, PORT_ICON_HEIGHT);

			// Port name + port type
			x = 0;
			if (imageID.equals(ContractModellingImageProvider.IMG_PORT_INPUT))
				x = PORT_ICON_WIDTH;
			gaService.setLocationAndSize(text, x, 0, roundedRectangle.getWidth() - PORT_ICON_WIDTH,
					(PORT_MIN_HEIGHT) / 2);
			gaService.setLocationAndSize(text2, x, PORT_MIN_HEIGHT / 2,
					roundedRectangle.getWidth() - PORT_ICON_WIDTH, (PORT_MIN_HEIGHT) / 2);

			// create link and wire it
			link(containerShape, addedClass);
		}
		final ChopboxAnchor anchor = peCreateService.createChopboxAnchor(containerShape);
//		anchor.set

		// call the layout feature
		layoutPictogramElement(containerShape);
		return containerShape;
	}

	int[] getPosition(IAddContext context, int portWidth, int portHeight) {
		int widthContainer = (context.getTargetContainer().getGraphicsAlgorithm().getWidth());
		int[] coordinaten = new int[2];

		if (((Ports) context.getNewObject()).getOuterDirection() == DirectionType.INTERNAL) {
			coordinaten[0] = 0;
			coordinaten[1] = context.getY();
			imageID = ContractModellingImageProvider.IMG_PORT_INPUT;
		} else {
			coordinaten[0] = widthContainer - portWidth;
			coordinaten[1] = context.getY();
			imageID = ContractModellingImageProvider.IMG_PORT_OUTPUT;
		}
		return coordinaten;
	}

}
