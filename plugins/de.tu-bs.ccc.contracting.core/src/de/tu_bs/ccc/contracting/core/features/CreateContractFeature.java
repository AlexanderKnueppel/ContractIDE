package de.tu_bs.ccc.contracting.core.features;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import general.SaveDomainModel;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.ContractType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.ViewPoint;

public class CreateContractFeature extends AbstractCreateFeature {
	private static  String type;
 
    private static final String TITLE = "Create class";
 
    private static final String USER_QUESTION = "Enter new class name";
 
    public CreateContractFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Contract", "Create Contract");
    }
 
    public boolean canCreate(ICreateContext context) {
    	if (context.getTargetContainer() instanceof ContainerShape) {
    		
    	Object bo =	getBusinessObjectForPictogramElement(context.getTargetContainer());
    	if (bo instanceof Module) {
			return true;
		}
    		
    	}
        return false;
    }
 
    public Object[] create(ICreateContext context) {
        // ask user for EClass name
      /*  String newClassName = ExampleUtil.askString(TITLE, USER_QUESTION, "");
        if (newClassName == null || newClassName.trim().length() == 0) {
            return EMPTY;
        }*/
 
        // create EClass
    	String[] selectionValues = new String[ViewPoint.values().length]; 
        Contract contract = MmFactory.eINSTANCE.createContract();
        for (int i = 0; i < ViewPoint.values().length; i++) {
			selectionValues[i]= ViewPoint.get(i).toString();
			
		}
        
        Object initialSelection =  ViewPoint.get(0);
        Object selection = JOptionPane.showInputDialog(null, "Chose Contract Dimension",
            "Dimension", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
       contract.setViewPoint(ViewPoint.get(selection.toString()));
       Module m = (Module) getBusinessObjectForPictogramElement(context.getTargetContainer());
       m.getContract().add(contract);
		contract.setModule(m);
       
        // do the add
        addGraphicalRepresentation(context, contract);
 
        // return newly created business object(s)
        return new Object[] { contract};
    }
}
