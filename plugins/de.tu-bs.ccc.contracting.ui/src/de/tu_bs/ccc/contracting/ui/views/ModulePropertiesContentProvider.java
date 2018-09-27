package de.tu_bs.ccc.contracting.ui.views;

import java.util.ArrayList;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class ModulePropertiesContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object object) {
		return null;
	}

	@Override
	public Object[] getElements(Object object) {
		String[] attributes = new String[] {"Name", };
		return null;
	}

	@Override
	public Object getParent(Object object) {
		return null;
	}

	@Override
	public boolean hasChildren(Object object) {
		return false;
	}
}
