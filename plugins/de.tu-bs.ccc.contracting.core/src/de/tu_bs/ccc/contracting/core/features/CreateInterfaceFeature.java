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
import org.eclipse.graphiti.mm.pictograms.Diagram;

import general.SaveDomainModel;
import de.tu_bs.de.ccc.contracting.Verification.Compound;
import de.tu_bs.de.ccc.contracting.Verification.Interface;
import de.tu_bs.de.ccc.contracting.Verification.MmFactory;

public class CreateInterfaceFeature extends AbstractCreateFeature implements ICreateFeature {
 
    private static final String TITLE = "Create class";
 
    private static final String USER_QUESTION = "Enter new class name";
 
    public CreateInterfaceFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, "Interface", "Creates an Interface");
    }
 
    public boolean canCreate(ICreateContext context) {
        return getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Compound;
    }
 
    public Object[] create(ICreateContext context) {
        // ask user for EClass name
      /*  String newClassName = ExampleUtil.askString(TITLE, USER_QUESTION, "");
        if (newClassName == null || newClassName.trim().length() == 0) {
            return EMPTY;
        }*/
 
        // create EClass
        Interface newClass = MmFactory.eINSTANCE.createInterface();
        
        newClass.setName("DefaultInterface");
        newClass.setName("Default Description");
        Compound cont = (Compound) getBusinessObjectForPictogramElement(context.getTargetContainer());
        newClass.setIsPartOf(cont);
        

 
        // do the add
        addGraphicalRepresentation(context, newClass);
 
        // return newly created business object(s)
        return new Object[] { newClass };
    }
}