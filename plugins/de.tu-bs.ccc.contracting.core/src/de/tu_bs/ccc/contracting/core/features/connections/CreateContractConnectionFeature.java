package de.tu_bs.ccc.contracting.core.features.connections;

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

import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class CreateContractConnectionFeature extends AbstractCreateConnectionFeature{

	public CreateContractConnectionFeature(IFeatureProvider fp) {
		super(fp, "Connect Contract", "Connect Contract with Module");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		if (!(context.getSourcePictogramElement() instanceof Diagram || context.getTargetPictogramElement() instanceof Diagram)) {
			PictogramElement pictSource = context.getSourcePictogramElement();
			PictogramElement pictTarget = context.getTargetPictogramElement();
			if (!(pictSource instanceof ContainerShape && pictTarget instanceof ContainerShape )) {
				
				return false;
			}
			EList<EObject> businessObjectsSource = pictSource.getLink().getBusinessObjects();
			EList<EObject> businessObjectsTarget = pictTarget.getLink().getBusinessObjects();
			return businessObjectsSource.size() == 1 && businessObjectsSource.get(0) instanceof Contract && businessObjectsTarget.size() == 1 && businessObjectsTarget.get(0) instanceof Module ;
		} else {
			return false;
		}
		}
	@Override
	public Connection create(ICreateConnectionContext context) {
		Anchor sourceAnchor = context.getSourceAnchor();
		Anchor targetAnchor = context.getTargetAnchor();
		
		EList<EObject> businessObjects = context.getSourcePictogramElement().getLink().getBusinessObjects();
		EList<EObject> businessObjects2 = context.getTargetPictogramElement().getLink().getBusinessObjects();
        Contract source = (Contract) businessObjects.get(0);
        Module target = (Module) businessObjects2.get(0);

        
            source.setModule(target);
            target.getContract().add(source);

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
			return businessObjects.get(0) instanceof Contract;
		} else {
			return false;
		}
	}

	
		
}
