package de.tu_bs.ccc.contracting.core.guiFeatures;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.mapping.ImportMapping;
import de.tu_bs.ccc.contracting.core.mapping.MappingEntry;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.idl.CidlPersistenceManager;
import de.tu_bs.ccc.contracting.idl.cidl.Interface;
import de.tu_bs.ccc.contracting.idl.cidl.Model;
import de.tu_bs.ccc.contracting.ui.dialogs.EditConsumerPortFeatureDialog;
import de.tu_bs.ccc.contracting.ui.dialogs.EditPortFeatureDialog;
import de.tu_bs.ccc.contracting.ui.dialogs.EditProviderPortFeatureDialog;

public class EditPortFeature extends AbstractCustomFeature {

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Ports) {
				Module m = ((Ports) bo).getModule();
				ret = (m.getModule()==null);
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

		// get all interfaces from all models
		List<Interface> interfaces = CidlPersistenceManager.getIdlModels(CoreUtil.getCurrentProject()).stream()
				.map(m -> ((Model) m).getInterfaces()).flatMap(i -> i.stream()).collect(Collectors.toList());

		EditPortFeatureDialog dialog;
		if (((Ports) object).getOuterDirection() == DirectionType.EXTERNAL)
			dialog = new EditConsumerPortFeatureDialog(shell, interfaces);
		else
			dialog = new EditProviderPortFeatureDialog(shell, interfaces);
		
		if (ImportMapping.getMappingEntry(((Ports) object).getModule()).size()>0) {
			
			MessageBox dialog2 = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
			dialog2.setText("Component already used");
			dialog2.setMessage("This compoent already has instances, do you really want to change it?");

			// open dialog and await user selection
			int returnCode = dialog2.open();
			if (returnCode == SWT.OK ) {
				dialog.setOldProperties(object);
				dialog.create();
				dialog.open();
			}

		} else {
			dialog.setOldProperties(object);
			dialog.create();
			dialog.open();
		}

	}
}
