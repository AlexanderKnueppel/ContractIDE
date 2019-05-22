package de.tu_bs.ccc.contracting.core.features;



import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.ccc.contracting.Verification.Ports;


public class CreatePortConnection extends AbstractCreateConnectionFeature {

	public CreatePortConnection(IFeatureProvider fp) {
		super(fp, "Connect Ports", "Connects two ports");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		if (!(context.getSourcePictogramElement() instanceof Diagram
				|| context.getTargetPictogramElement() instanceof Diagram)) {
			PictogramElement pictSource = context.getSourcePictogramElement();
			PictogramElement pictTarget = context.getTargetPictogramElement();
			if (!(pictSource instanceof ContainerShape && pictTarget instanceof ContainerShape)) {

				return false;
			}
			EList<EObject> businessObjectsSource = pictSource.getLink().getBusinessObjects();
			EList<EObject> businessObjectsTarget = pictTarget.getLink().getBusinessObjects();
			ContainerShape cs1 = (ContainerShape) context.getSourcePictogramElement();
			ContainerShape cs2 = (ContainerShape) context.getTargetPictogramElement();
			if(businessObjectsSource.size() == 1 && businessObjectsSource.get(0) instanceof Ports
					&& businessObjectsTarget.size() == 1 && businessObjectsTarget.get(0) instanceof Ports
					&& cs1.getContainer()!=cs2.getContainer())
			{
				Ports port1 = (Ports) businessObjectsSource.get(0);
				Ports port2 = (Ports) businessObjectsTarget.get(0);
				return port1.getService().equals(port2.getService());
			}
		} else {
			return false;
		}
		return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Anchor sourceAnchor = context.getSourceAnchor();
		Anchor targetAnchor = context.getTargetAnchor();

		EList<EObject> businessObjects = context.getSourcePictogramElement().getLink().getBusinessObjects();
		EList<EObject> businessObjects2 = context.getTargetPictogramElement().getLink().getBusinessObjects();
		ContainerShape cs1 = (ContainerShape) context.getSourcePictogramElement();
		ContainerShape cs2 = (ContainerShape) context.getTargetPictogramElement();
		Ports source = (Ports) businessObjects.get(0);

		Ports target = (Ports) businessObjects2.get(0);

		if (cs1.getContainer().getContainer() == cs2.getContainer().getContainer()) {

			source.getPorts().add(target);
			target.setPortseOpposite(source);
		} else if (cs1.getContainer() == cs2.getContainer().getContainer()
				|| cs2.getContainer() == cs1.getContainer().getContainer()) {
			source.getInsidePorts().add(target);
			target.setInsidePortseOpposite(source);

		}

		AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
		getFeatureProvider().addIfPossible(addContext);

		return null;

	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if (!(context.getSourcePictogramElement() instanceof Diagram)) {
			PictogramElement pict = context.getSourcePictogramElement();
			if (!(pict instanceof ContainerShape)) {

				return false;
			}
			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.get(0) instanceof Ports;
		} else {
			return false;
		}
	}

}
