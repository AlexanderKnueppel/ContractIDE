package de.tu_bs.ccc.contracting.core.update;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class UpdatePortFeature extends AbstractUpdateFeature {

	public UpdatePortFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return (bo instanceof Ports);
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Ports port = (Ports) getBusinessObjectForPictogramElement(pictogramElement);
		if (pictogramElement instanceof ContainerShape) {

			ContainerShape cs = (ContainerShape) pictogramElement;
			Shape name = cs.getChildren().get(0);
			Shape type = cs.getChildren().get(1);
			Text nameText = (Text) name.getGraphicsAlgorithm();
			Text typeText = (Text) type.getGraphicsAlgorithm();
			String suffix = "";
			if (port.getType().getValue() == PortType.SERVICE_VALUE) {
				suffix += " : " + port.getService();
			}
			if (nameText.getValue().equals(port.getName() + suffix)
					&& typeText.getValue().equals(port.getType().toString())) {
				return Reason.createFalseReason("Name is out of date");
			}

		}
		return Reason.createTrueReason();
	}

	@Override
	public boolean update(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Ports port = (Ports) getBusinessObjectForPictogramElement(pictogramElement);
		if (pictogramElement instanceof ContainerShape) {

			ContainerShape cs = (ContainerShape) pictogramElement;
			Shape name = cs.getChildren().get(0);
			Shape type = cs.getChildren().get(1);
			Text nameText = (Text) name.getGraphicsAlgorithm();
			String suffix = "";
			if (port.getType().getValue() == PortType.SERVICE_VALUE) {
				suffix += " : " + port.getService();
			}
			nameText.setValue(port.getName() + suffix);
			Text typeText = (Text) type.getGraphicsAlgorithm();
			typeText.setValue(port.getType().toString());

			return true;
		}
		return false;
	}
}
