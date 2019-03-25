package de.tu_bs.ccc.contracting.ui.views;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;

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
	
	public ArrayList<ModulePropertyElement> getPortElements(Object object) {
		Ports p = (Ports) object;
		ArrayList<ModulePropertyElement> elements = new ArrayList<ModulePropertyElement>();

		elements.add(new ModulePropertyElement("Name", p.getName(), p,
				new TextCellEditor((Composite) getViewer().getControl())));

		elements.add(new ModulePropertyElement("Direction",
				(p.getOuterDirection() == DirectionType.EXTERNAL) ? "Provider" : "Consumer", p,
				new TextCellEditor((Composite) getViewer().getControl())));

		elements.add(new ModulePropertyElement("Type", p.getType().getName(), p,
				new TextCellEditor((Composite) getViewer().getControl())));

		if (p.getType() == PortType.SERVICE) {
			elements.add(new ModulePropertyElement("Service interface", p.getService(), p,
					new TextCellEditor((Composite) getViewer().getControl())));
		}

		elements.add(new ModulePropertyElement("Filter", p.getFilter(), p,
				new TextCellEditor((Composite) getViewer().getControl())));

		if (p.getOuterDirection() == DirectionType.EXTERNAL) {
			elements.add(new ModulePropertyElement("Max. clients", p.getMaxClients() + "", p,
					new TextCellEditor((Composite) getViewer().getControl())));
			elements.add(new ModulePropertyElement("Provider type", p.getProviderType().getName(), p,
					new TextCellEditor((Composite) getViewer().getControl())));
		} else {
			elements.add(new ModulePropertyElement("Function", p.getFunction(), p,
					new TextCellEditor((Composite) getViewer().getControl())));
			elements.add(new ModulePropertyElement("Label", p.getLabel(), p,
					new TextCellEditor((Composite) getViewer().getControl())));
		}

		return elements;
	}
	
	public ArrayList<ModulePropertyElement> getComponentElements(Object object) {
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
			elements.add(new ModulePropertyElement("Realizes", realizedBy, m,
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
		return elements;
	}

	@Override
	public Object[] getElements(Object object) {
		if(object instanceof Module)
			return getComponentElements(object).toArray();
		else if(object instanceof Ports)
			return getPortElements(object).toArray();
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
