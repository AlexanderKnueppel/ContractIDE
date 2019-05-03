package de.tu_bs.ccc.contracting.ui.views.enviromentalView;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import de.tu_bs.ccc.contracting.Verification.Property;

public class LabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object arg0, int arg1) {
		Property parameter = (Property) arg0;
		switch (arg1) {
		case 0:
			return parameter.getName();
		case 1:
			return parameter.getType();
		case 2:
			return parameter.getValue();
		default:
			return null;
		}
	}

}
