package de.tu_bs.ccc.contracting.ui.views;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;

public class ModulePropertiesContentProvider implements ITreeContentProvider {
	private ColumnViewer viewer;

	ModulePropertiesContentProvider(ColumnViewer viewer) {
		this.viewer = viewer;
	}

	public ColumnViewer getViewer() {
		return viewer;
	}

	@Override
	public Object[] getChildren(Object object) {
		return null;
	}

	@Override
	public Object[] getElements(Object object) {
		Module m = (Module) object;
		ArrayList<ModulePropertyElement> elements = new ArrayList<ModulePropertyElement>();

		elements.add(new ModulePropertyElement("Name", m.getName(), m,
				new TextCellEditor((Composite) getViewer().getControl())));
		elements.add(new ModulePropertyElement("Version", m.getVersion(), m,
				new TextCellEditor((Composite) getViewer().getControl())));
		elements.add(new ModulePropertyElement("Description", m.getDescription(), m,
				new TextCellEditor((Composite) getViewer().getControl())));

		// Type
		String type = "Atomic";
		if (m instanceof Compound)
			type = "Compound";
		else if (m instanceof Abstract)
			type = "Abstract";

		elements.add(
				new ModulePropertyElement("Type", type, m, new TextCellEditor((Composite) getViewer().getControl())));

		// Realized by
		if (m instanceof Component || m instanceof Compound) {
			String realizedBy = "";
			for (Abstract l : m.getRealizedBy()) {
				realizedBy += l.getName() + " " + l.getVersion() + ", ";
			}
			if (realizedBy.length() > 0)
				realizedBy = realizedBy.substring(0, realizedBy.length() - 2);
			elements.add(new ModulePropertyElement("Realized by", realizedBy, m,
					new TextCellEditor((Composite) getViewer().getControl())));
		}
		
		// Binary
		if (m instanceof Component) {
			elements.add(
					new ModulePropertyElement("Binary", ((Component)m).getBinary(), m, new TextCellEditor((Composite) getViewer().getControl()), true) {
						public void update(Object obj) {
							((Component)getObject()).setBinary((String)obj);
						}
					});
		}

		return elements.toArray();
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
