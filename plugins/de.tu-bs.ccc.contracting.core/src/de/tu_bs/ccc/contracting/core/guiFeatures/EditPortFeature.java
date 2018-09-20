package de.tu_bs.ccc.contracting.core.guiFeatures;


import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.ui.dialogs.EditPortFeatureDialog;


public class EditPortFeature extends AbstractCustomFeature  {

	@Override
	public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Ports) {
                ret = true;
            }
        }
        return ret;
	}

	public EditPortFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Object object = getBusinessObjectForPictogramElement(pes[0]);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		EditPortFeatureDialog dialog = new EditPortFeatureDialog(shell);
		dialog.setOldProperties(object);
		dialog.create();
		dialog.open();
		
	}
}
