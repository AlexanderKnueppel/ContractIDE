package de.tu_bs.ccc.contracting.core.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.ProviderType;
import de.tu_bs.ccc.contracting.core.util.PortTypeManager;

public class CreatePortFeature extends AbstractCreateFeature implements ICreateFeature {
	public static final PortType pt = PortType.JAVA;

	public CreatePortFeature(IFeatureProvider fp) {
		super(fp, "Port", "Adds a Port to a Module");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {

				return false;
			}

			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Module;
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {
		Ports addedObject = MmFactory.eINSTANCE.createPorts();

		addedObject.setType(pt);
		addedObject.setService(PortTypeManager.getTypes().get(0)); // use first element as default one
		
		PictogramElement pict = context.getTargetContainer();
		EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
		Module expandWithPort = ((Module) businessObjects.get(0));
		String classname = "port" + expandWithPort.getPorts().size();
		addedObject.setName(classname);

		addedObject.setLabel("");
		addedObject.setFunction("");
		addedObject.setFilter("");
		addedObject.setProviderType(ProviderType.NATIVE);
		addedObject.setMaxClients(-1);

		expandWithPort.getPorts().add(addedObject);
		AddContext contextAdd = new AddContext(context, addedObject);
		contextAdd.setTargetContainer(context.getTargetContainer());

		int widthContainer = (context.getTargetContainer().getGraphicsAlgorithm().getWidth());
		int calcPosX = context.getX();
		calcPosX = calcPosX - (widthContainer / 2);

		if (calcPosX < 0) {
			addedObject.setOuterDirection(DirectionType.INTERNAL);
		} else {
			addedObject.setOuterDirection(DirectionType.EXTERNAL);
		}

		addGraphicalRepresentation(contextAdd, addedObject);

		return new Object[] { addedObject };
	}

}
