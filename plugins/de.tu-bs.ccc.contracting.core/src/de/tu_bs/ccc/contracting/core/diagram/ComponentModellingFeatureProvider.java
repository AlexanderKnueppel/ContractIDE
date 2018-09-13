package de.tu_bs.ccc.contracting.core.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IPrintFeature;
import org.eclipse.graphiti.features.ISaveImageFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.impl.AbstractFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import de.tu_bs.ccc.contracting.core.features.AddComponentFeature;
import de.tu_bs.ccc.contracting.core.features.AddContractFeature;
import de.tu_bs.ccc.contracting.core.features.AddDomainObjectFeature;
import de.tu_bs.ccc.contracting.core.features.AddInterfaceFeature;
import de.tu_bs.ccc.contracting.core.features.AddPortConnetion;
import de.tu_bs.ccc.contracting.core.features.AddPortFeature;
import de.tu_bs.ccc.contracting.core.features.CreateComponentFeature;
import de.tu_bs.ccc.contracting.core.features.CreateContractFeature;
import de.tu_bs.ccc.contracting.core.features.CreateDomainObjectConnectionConnectionFeature;
import de.tu_bs.ccc.contracting.core.features.CreateDomainObjectFeature;
import de.tu_bs.ccc.contracting.core.features.CreateInterfaceFeature;
import de.tu_bs.ccc.contracting.core.features.CreatePortConnection;
import de.tu_bs.ccc.contracting.core.features.CreatePortFeature;
import de.tu_bs.ccc.contracting.core.features.LayoutDomainObjectFeature;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Interface;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class ComponentModellingFeatureProvider extends DefaultFeatureProvider {

	public ComponentModellingFeatureProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] {new CreateDomainObjectFeature(this), new CreateComponentFeature(this), new CreateContractFeature(this),
				new CreateInterfaceFeature(this), new CreatePortFeature(this)};
		
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] {new CreateDomainObjectConnectionConnectionFeature(this), new CreatePortConnection(this)};
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		Object test = context.getNewObject();
		
		if (test instanceof Component ) {
					return new AddComponentFeature(this);
				}
	
		else if (context instanceof IAddContext &&context.getNewObject() instanceof Contract) {
	        return new AddContractFeature(this);
	        
	    }
		
		else  if (context instanceof IAddContext  && context.getNewObject() instanceof Interface ) {
			return new AddInterfaceFeature(this);
		}
		else  if (context instanceof IAddContext && context.getNewObject() instanceof Compound) {
			return new AddDomainObjectFeature(this);
		}
		else  if (context instanceof IAddContext && context.getNewObject() instanceof Ports) {
			return new AddPortFeature(this);
		}
		else if (context instanceof IAddConnectionContext) {
			return new AddPortConnetion(this);
			
		}

		return super.getAddFeature(context);
	}
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		// TODO: check for right domain object instances below
		if (context.getPictogramElement() instanceof ContainerShape /* && getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof <DomainObject> */) {
			return  new LayoutDomainObjectFeature(this);
		}
	
		return super.getLayoutFeature(context);
	}
}
