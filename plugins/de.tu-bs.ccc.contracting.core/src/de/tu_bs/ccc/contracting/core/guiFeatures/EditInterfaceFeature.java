package de.tu_bs.ccc.contracting.core.guiFeatures;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;

import de.tu_bs.de.ccc.contracting.Verification.Compound;
import de.tu_bs.de.ccc.contracting.Verification.Interface;
import de.tu_bs.de.ccc.contracting.Verification.Module;
import windows.InterfaceList;

public class EditInterfaceFeature extends AbstractCustomFeature {

	public EditInterfaceFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Module) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public String getName() {
		return "Check Interface";
	}

	@Override
	public String getDescription() {

		return "Edit Interfaces/Implemnetaitons";
	}

	@Override
	public String getImageId() {
		return IPlatformImageConstants.IMG_ECLIPSE_QUICKASSIST;
	}

	@Override
	public boolean isAvailable(IContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		Object bo = getBusinessObjectForPictogramElement(pes[0]);
		if (bo instanceof Interface) {
			Interface inte = (Interface) getBusinessObjectForPictogramElement(pes[0]);
			String[] list = new String[inte.getRealizes().size()];
			for (int i = 0; i < list.length; i++) {
				list[i]= inte.getRealizes().get(i).getName();
			}
			InterfaceList il = new InterfaceList(list);
			il.setVisible(true);
			int number = -1;
			number = il.getCount();
			
			if (number != -1 && il.isDelete()) {
				inte.getRealizes().remove(number);
				
			}

		} else if (bo instanceof Module) {
			Module mod = (Module) getBusinessObjectForPictogramElement(pes[0]);
			String[] list = new String[mod.getGetsrealized().size()];
			for (int i = 0; i < list.length; i++) {
				list[i]= mod.getGetsrealized().get(i).getName();
			}
					
			InterfaceList il = new InterfaceList(list);
			il.setVisible(true);

			int number = -1;
			number = il.getCount();
			if (number != -1 && il.isDelete()) {
				mod.getGetsrealized().remove(number);
			}

		}
	

	}

}
