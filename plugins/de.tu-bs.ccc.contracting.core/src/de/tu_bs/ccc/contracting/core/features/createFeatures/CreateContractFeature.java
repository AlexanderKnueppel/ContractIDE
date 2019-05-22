package de.tu_bs.ccc.contracting.core.features.createFeatures;

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PropertyType;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;
import de.tu_bs.ccc.contracting.core.localization.StringTable;

public class CreateContractFeature extends AbstractCreateFeature {


	public CreateContractFeature(IFeatureProvider fp) {
		// set name and description of the creation feature
		super(fp, StringTable.CREATE_CONTRACT_NAME, StringTable.CREATE_CONTRACT_DESC);
	}

	public boolean canCreate(ICreateContext context) {
		if (context.getTargetContainer() instanceof ContainerShape) {

			Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
			if (bo instanceof Module) {
				return true;
			}

		}
		return false;
	}

	public Object[] create(ICreateContext context) {
		// create EClass
		String[] selectionValues = new String[ViewPoint.values().length];
		Contract contract = MmFactory.eINSTANCE.createContract();
		for (int i = 0; i < ViewPoint.values().length; i++) {
			selectionValues[i] = ViewPoint.get(i).toString();

		}

		Object initialSelection = ViewPoint.get(0);
		Object selection = JOptionPane.showInputDialog(null, StringTable.CREATE_CONTRACT_WINDOW_TEXT, StringTable.CREATE_CONTRACT_WINDOW_TITLE,
				JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		contract.setViewPoint(ViewPoint.get(selection.toString()));
		Module m = (Module) getBusinessObjectForPictogramElement(context.getTargetContainer());
		m.getContract().add(contract);
		contract.setModule(m);
		
		if(contract.getViewPoint() == ViewPoint.FUNCTIONAL) {
			Assumption a = MmFactory.eINSTANCE.createAssumption();
			a.setProperty("true");
			a.setPropertyTipe(PropertyType.EQUATION);
			a.setContract(contract);
			contract.getAssumption().add(a);
			
			Guarantee g = MmFactory.eINSTANCE.createGuarantee();
			g.setProperty("true");
			g.setPropertyTipe(PropertyType.EQUATION);
			g.setContract(contract);
			contract.getGuarantee().add(g);
		} else 	if(contract.getViewPoint() == ViewPoint.MEMORY) {
			Assumption a = MmFactory.eINSTANCE.createAssumption();
			a.setProperty(StringTable.CONTRACT_ASSUMPTION_DEFAULT_MEMORY);
			a.setPropertyTipe(PropertyType.MEMORY);
			a.setContract(contract);
			contract.getAssumption().add(a);
			
			Guarantee g = MmFactory.eINSTANCE.createGuarantee();
			g.setProperty(StringTable.CONTRACT_GUARANTEE_DEFAULT_MEMORY);
			g.setPropertyTipe(PropertyType.MEMORY);
			g.setContract(contract);
			contract.getGuarantee().add(g);
		} else 	if(contract.getViewPoint() == ViewPoint.TIMING) {
			Assumption a = MmFactory.eINSTANCE.createAssumption();
			a.setProperty(StringTable.CONTRACT_ASSUMPTION_DEFAULT_TIME);
			a.setPropertyTipe(PropertyType.MINDURATION);
			a.setContract(contract);
			contract.getAssumption().add(a);
			
			Guarantee g = MmFactory.eINSTANCE.createGuarantee();
			g.setProperty(StringTable.CONTRACT_GUARANTEE_DEFAULT_TIME);
			g.setPropertyTipe(PropertyType.MINDURATION);
			g.setContract(contract);
			contract.getGuarantee().add(g);
		}


		// do the add
		addGraphicalRepresentation(context, contract);
		
		//getFeatureProvider().getDirectEditingInfo().setActive(true);

		// return newly created business object(s)
		return new Object[] { contract };
	}
}
