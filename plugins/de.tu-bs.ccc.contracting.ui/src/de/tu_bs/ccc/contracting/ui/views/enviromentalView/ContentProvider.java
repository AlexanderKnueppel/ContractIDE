package de.tu_bs.ccc.contracting.ui.views.enviromentalView;

import de.tu_bs.ccc.contracting.Verification.Module;

public class ContentProvider
		implements org.eclipse.jface.viewers.IStructuredContentProvider {

	@Override
	public Object[] getElements(Object arg0) {
		Module graph = (Module) arg0;
		if(graph.getEnviromentalProperties()!=null)
		return graph.getEnviromentalProperties().toArray();
		return null;
	}

}
