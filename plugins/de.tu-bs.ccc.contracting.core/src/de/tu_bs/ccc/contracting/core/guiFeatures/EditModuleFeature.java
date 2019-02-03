package de.tu_bs.ccc.contracting.core.guiFeatures;


import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.ui.dialogs.EditModuleFeatureDialog;


public class EditModuleFeature extends AbstractCustomFeature {

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement pes = context.getPictogramElements()[0];
		if (pes != null) {
			Object bo = getBusinessObjectForPictogramElement(pes);
			if (bo instanceof Module) {
				Module m = (Module)bo;
				ret = (m.getModule()==null);
			}
		}
		return ret;
	}

	public EditModuleFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Object object = getBusinessObjectForPictogramElement(pes[0]);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		EditModuleFeatureDialog dialog = new EditModuleFeatureDialog(shell);
		dialog.setOldProperties(object);
		dialog.create();
		dialog.open();
		updatePictogramElement(pes[0]);
	}
}
