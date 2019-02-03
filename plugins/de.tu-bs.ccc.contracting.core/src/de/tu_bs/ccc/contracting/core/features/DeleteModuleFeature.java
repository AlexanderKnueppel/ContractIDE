package de.tu_bs.ccc.contracting.core.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.mapping.ImportMapping;

public class DeleteModuleFeature extends DefaultDeleteFeature {

	public DeleteModuleFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(IDeleteContext context) {
		PictogramElement pes = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pes);
		Module m = (Module) bo;
		if (m.getModule()!=null) {
			ImportMapping.deleteMappingEntry(m);
		}
		super.delete(context);
	}

}
