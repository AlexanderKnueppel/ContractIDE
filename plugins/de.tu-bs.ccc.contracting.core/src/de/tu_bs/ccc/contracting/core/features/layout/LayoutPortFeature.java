package de.tu_bs.ccc.contracting.core.features.layout;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.ui.services.IUiLayoutService;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.diagram.ContractModellingImageProvider;
import de.tu_bs.ccc.contracting.core.features.addFeature.AddPortFeature;

public class LayoutPortFeature extends AbstractLayoutFeature implements ILayoutFeature {
	private String imageID;

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

	int[] getPosition(ContainerShape cs, int portWidth, int portHeight) {
		int widthContainer = (cs.getContainer().getGraphicsAlgorithm().getWidth());
		int[] coordinaten = new int[2];

		if (((Ports) getBusinessObjectForPictogramElement(cs)).getOuterDirection() == DirectionType.INTERNAL) {
			coordinaten[0] = 0;
			coordinaten[1] = cs.getGraphicsAlgorithm().getY();
			imageID = ContractModellingImageProvider.IMG_PORT_INPUT;
		} else {
			coordinaten[0] = widthContainer - portWidth;
			coordinaten[1] = cs.getGraphicsAlgorithm().getY();
			imageID = ContractModellingImageProvider.IMG_PORT_OUTPUT;
		}
		return coordinaten;
	}

	@Override
	public boolean layout(ILayoutContext context) {
		boolean anythingChanged = false;
		ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		IGaService gaService = Graphiti.getGaService();

		// Get children
		Rectangle rectangle = (Rectangle) containerShape.getGraphicsAlgorithm();
		Image icon = (Image) rectangle.getGraphicsAlgorithmChildren().get(0);
		Text name = (Text) containerShape.getChildren().get(0).getGraphicsAlgorithm();
		Text type = (Text) containerShape.getChildren().get(1).getGraphicsAlgorithm();

		IUiLayoutService uil = GraphitiUi.getUiLayoutService();
		IDimension size = uil.calculateTextSize(name.getValue(), name.getFont());
		int newPortWidth = Math.max(AddPortFeature.PORT_MIN_WIDTH,
				size.getWidth() + AddPortFeature.PORT_PADDING + AddPortFeature.PORT_ICON_WIDTH);

		// rectangle
		int x = getPosition(containerShape, newPortWidth, AddPortFeature.PORT_MIN_HEIGHT)[0],
				y = getPosition(containerShape, newPortWidth, AddPortFeature.PORT_MIN_HEIGHT)[1];
		gaService.setLocationAndSize(rectangle, x, y, newPortWidth, AddPortFeature.PORT_MIN_HEIGHT);

		// Port icon
		x = 0;
		y = (AddPortFeature.PORT_MIN_HEIGHT / 2) - (AddPortFeature.PORT_ICON_HEIGHT / 2);
		if (imageID.equals(ContractModellingImageProvider.IMG_PORT_OUTPUT)) {
			x = rectangle.getWidth() - AddPortFeature.PORT_ICON_WIDTH;
		}
		icon.setId(imageID);
		gaService.setLocationAndSize(icon, x, y, AddPortFeature.PORT_ICON_WIDTH, AddPortFeature.PORT_ICON_HEIGHT);

		// Port name + port type
		x = 0;
		if (imageID.equals(ContractModellingImageProvider.IMG_PORT_INPUT))
			x = AddPortFeature.PORT_ICON_WIDTH;
		gaService.setLocationAndSize(name, x, 0, rectangle.getWidth() - AddPortFeature.PORT_ICON_WIDTH,
				(AddPortFeature.PORT_MIN_HEIGHT) / 2);
		gaService.setLocationAndSize(type, x, AddPortFeature.PORT_MIN_HEIGHT / 2,
				rectangle.getWidth() - AddPortFeature.PORT_ICON_WIDTH, (AddPortFeature.PORT_MIN_HEIGHT) / 2);
		
		System.out.println("Hello");

		anythingChanged = true;

		return anythingChanged;
	}

}
