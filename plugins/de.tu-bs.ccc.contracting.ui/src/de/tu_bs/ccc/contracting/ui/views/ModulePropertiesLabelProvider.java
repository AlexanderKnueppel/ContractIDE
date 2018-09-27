package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

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
		if (element instanceof ModulePropertyElement) {
			switch (columnIndex) {
			case 0:
				return ((ModulePropertyElement) element).getAttribute();
			case 1:
				return ((ModulePropertyElement) element).getValue();
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
