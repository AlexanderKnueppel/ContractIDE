package de.tu_bs.ccc.contracting.core.features;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.BinaryIO.Version;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import general.SaveDomainModel;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.MmPackage;

public class CreatePortFeature extends AbstractCreateFeature implements ICreateFeature {
	public static final PortType pt = PortType.STRING;

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
		PictogramElement pict = context.getTargetContainer();
		EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
		Module expandWithPort = ((Module) businessObjects.get(0));
		String classname = "port"+expandWithPort.getPorts().size();
		addedObject.setName(classname);
		
		expandWithPort.getPorts().add(addedObject);
		AddContext contextAdd = new AddContext(context, addedObject);
		contextAdd.setTargetContainer(context.getTargetContainer());
		addGraphicalRepresentation(contextAdd, addedObject);

//		 try {
//		 SaveDomainModel.saveToModelFile(addedObject, getDiagram());
//		 } catch (CoreException | IOException e) {
//		 JOptionPane.showConfirmDialog(null, "Fehler");
//		 }
		return new Object[] { addedObject };
	}

}
