package de.tu_bs.ccc.contracting.core.guiFeatures;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.core.util.PortTypeManager;
import de.tu_bs.ccc.contracting.idl.CidlPersistenceManager;
import de.tu_bs.ccc.contracting.idl.cidl.Interface;
import de.tu_bs.ccc.contracting.idl.cidl.Model;
import de.tu_bs.ccc.contracting.ui.dialogs.EditConsumerPortFeatureDialog;
import de.tu_bs.ccc.contracting.ui.dialogs.EditPortFeatureDialog;
import de.tu_bs.ccc.contracting.ui.dialogs.EditProviderPortFeatureDialog;

public class EditPortFeature extends AbstractCustomFeature {
	private boolean changed = true;

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

		// get all interfaces from all models
		List<Interface> interfaces = CidlPersistenceManager.getIdlModels(CoreUtil.getCurrentProject()).stream()
				.map(m -> ((Model) m).getInterfaces()).flatMap(i -> i.stream()).collect(Collectors.toList());
		
		// get all allowed java types for the ports
		List<String> types = PortTypeManager.getTypes();

		EditPortFeatureDialog dialog;
		if(((Ports)object).getOuterDirection() == DirectionType.INTERNAL)
			dialog = new EditConsumerPortFeatureDialog(shell, types, interfaces);
		else
			dialog = new EditProviderPortFeatureDialog(shell, types, interfaces);
		
		dialog.setOldProperties(object);
		dialog.create();
		dialog.open();
		
		changed = dialog.getReturnCode() == EditPortFeatureDialog.OK;
	}

	@Override
	public boolean hasDoneChanges() {
		return changed;
	}
}
