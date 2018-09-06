package de.tu_bs.ccc.contracting.core.features;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import general.SaveDomainModel;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateDomainObjectFeature extends AbstractCreateFeature implements
		ICreateFeature {

	public CreateDomainObjectFeature(IFeatureProvider fp) {
		super(fp, "Compound", "Creates a new Compound");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		// TODO: create the domain object here
		 EClass newClass = EcoreFactory.eINSTANCE.createEClass();
		newClass.setName("dsasad");
		try {
			SaveDomainModel.saveToModelFile(newClass, getDiagram() );
		} catch (CoreException | IOException e) {
			System.out.println("SpeicherFehler");
			e.printStackTrace();
		}
        getDiagram().eResource().getContents().add(newClass);

		addGraphicalRepresentation(context, newClass);
		return new EClass[] { newClass };
	}
}
