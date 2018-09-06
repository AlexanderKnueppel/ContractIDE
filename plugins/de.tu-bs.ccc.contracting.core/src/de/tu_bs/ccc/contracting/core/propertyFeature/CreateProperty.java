package de.tu_bs.ccc.contracting.core.propertyFeature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import de.tu_bs.de.ccc.contracting.Verification.Assumption;
import de.tu_bs.de.ccc.contracting.Verification.Contract;
import de.tu_bs.de.ccc.contracting.Verification.ContractProperty;
import de.tu_bs.de.ccc.contracting.Verification.ContractType;
import de.tu_bs.de.ccc.contracting.Verification.Guarantee;
import de.tu_bs.de.ccc.contracting.Verification.Module;
import de.tu_bs.de.ccc.contracting.Verification.Ports;
import de.tu_bs.de.ccc.contracting.Verification.PropertyType;
import de.tu_bs.de.ccc.contracting.Verification.MmFactory;
import de.tu_bs.de.ccc.contracting.Verification.ViewPoint;

import windows.PropertyWindow;

public class CreateProperty extends AbstractCreateFeature {

	public CreateProperty(IFeatureProvider fp) {
		super(fp, "Contract Porperty", "Creates a Contract Property");
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
			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Contract;
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {
    	
		PictogramElement pict = context.getTargetContainer();
		EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
		Contract containingContract = ((Contract) businessObjects.get(0));
		PropertyWindow p = new PropertyWindow("",0,0);
			p.setVisible(true);
			if (p.getAssumption()==ContractType.ASSUMPTION_VALUE) {
				Assumption a = MmFactory.eINSTANCE.createAssumption();

				a.setPropertyTipe(PropertyType.values()[p.getProptype()]);
				a.setProperty(p.getProp());
				containingContract.getAssumption().add(a);
			a.setContract(containingContract);
			updatePictogramElement(pict);
			return new Object[] { a };
			}
			else if (p.getAssumption()==ContractType.GUARANTEE_VALUE) {
				Guarantee g = MmFactory.eINSTANCE.createGuarantee();
				
				g.setPropertyTipe(PropertyType.values()[p.getProptype()]);
				containingContract.getGuarantee().add(g);
				g.setContract(containingContract);
				g.setProperty(p.getProp());
				updatePictogramElement(context.getTargetContainer());
				return new Object[] { g };
			}
		
		
		
		
		
				
		
		
		return null;
	}

}
