package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.tu_bs.ccc.contracting.Verification.Module;

public class ModulePropertiesLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof Module) {
			Module node = (Module) element;
			switch (columnIndex) {
			case 0:
				
			case 1:
				return node.getName();
			default:
				break;
			}
		} 
		return null;
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
