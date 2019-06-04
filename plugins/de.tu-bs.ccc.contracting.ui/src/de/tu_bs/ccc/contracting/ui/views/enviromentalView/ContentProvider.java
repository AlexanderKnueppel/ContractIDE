package de.tu_bs.ccc.contracting.ui.views.enviromentalView;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;

public class ContentProvider implements org.eclipse.jface.viewers.IStructuredContentProvider {

	@Override
	public Object[] getElements(Object arg0) {
		if (arg0 instanceof Module) {
			Module graph = (Module) arg0;
			if (graph.getEnviromentalProperties() != null)
				return graph.getEnviromentalProperties().toArray();
		}
		if (arg0 instanceof Ports) {
			Ports p = (Ports) arg0;
			Module graph = p.getModule();
			if (graph.getEnviromentalProperties() != null)
				return graph.getEnviromentalProperties().toArray();
		}
		return null;
	}

}
