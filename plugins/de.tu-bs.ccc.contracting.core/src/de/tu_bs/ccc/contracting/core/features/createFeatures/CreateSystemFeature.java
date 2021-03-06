package de.tu_bs.ccc.contracting.core.features.createFeatures;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.localization.StringTable;
import general.SaveDomainModel;

public class CreateSystemFeature extends AbstractCreateFeature implements ICreateFeature {


	public CreateSystemFeature(IFeatureProvider fp) {
		// set name and description of the creation feature
		super(fp, StringTable.CREATE_SYSTEM_NAME, StringTable.CREATE_SYSTEM_DESC);
	}

	public boolean canCreate(ICreateContext context) {
		if (context.getTargetContainer() instanceof Diagram) {
			return true;
		}
		return false;
	}

	public Object[] create(ICreateContext context) {
		System newClass = MmFactory.eINSTANCE.createSystem();
		newClass.setName(StringTable.CREATE_SYSTEM_DEFAULT_NAME);
		try {
			SaveDomainModel.saveToModelFile(newClass, getDiagram());
		} catch (CoreException | IOException e) {
			e.printStackTrace();
		}

		// do the add
		addGraphicalRepresentation(context, newClass);

		// return newly created business object(s)
		return new Object[] { newClass };
	}
}