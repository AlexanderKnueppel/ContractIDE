package de.tu_bs.ccc.contracting.core.features.createFeatures;


import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.core.localization.StringTable;

public class CreateAbstractFeature extends AbstractCreateFeature implements ICreateFeature {
 
 
    public CreateAbstractFeature(IFeatureProvider fp) {
        // set name and description of the creation feature
        super(fp, StringTable.CREATE_ABSTRACT_NAME, StringTable.CREATE_ABSTRACT_DESC);
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
        Abstract newClass = MmFactory.eINSTANCE.createAbstract();
        
        newClass.setName(StringTable.CREATE_ABSTRACT_DEFAULTNAME);
        Compound cont = (Compound) getBusinessObjectForPictogramElement(context.getTargetContainer());
        newClass.setIsPartOf(cont);
        

 
        // do the add
        addGraphicalRepresentation(context, newClass);
 
        // return newly created business object(s)
        return new Object[] { newClass };
    }
}