package de.tu_bs.ccc.contracting.core.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.mapping.ImportMapping;

public class DeletePortFeature extends DefaultDeleteFeature {

	public DeletePortFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(IDeleteContext context) {
		PictogramElement pes = context.getPictogramElement();
		Object object = getBusinessObjectForPictogramElement(pes);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		if (ImportMapping.getMappingEntry(((Ports) object).getModule()).size() > 0) {

			MessageBox dialog2 = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
			dialog2.setText("Component already used");
			dialog2.setMessage("This component already has instances, do you really want to change it?");
			if(((Ports) object).getModule().getModule()!=null) {
				dialog2.setText("Component is an Instance");
				dialog2.setMessage("This component is an instance, you shouldn't delete Ports as it this could cause synch problems?");			
			}

			// open dialog and await user selection
			
			int returnCode = dialog2.open();
			if (returnCode == SWT.CANCEL) {
				return;
			}
		}
		super.delete(context);
	}

}
