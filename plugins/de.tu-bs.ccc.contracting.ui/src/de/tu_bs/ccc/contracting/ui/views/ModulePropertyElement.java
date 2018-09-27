package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public class ModulePropertyElement {
	private String attribute = "";
	private String value = "";
	private Object object = "";
	
	public String getAttribute() {
		return attribute;
	}

	public String getValue() {
		return value;
	}

	public Object getObject() {
		return object;
	}
	
	public ModulePropertyElement(String attr, String val, Object obj) {
		attribute = attr;
		value = val;
		object = obj;
	}
	
	protected boolean isVisible() {
		return false;
	}
	
	protected CellEditor getCellEditor() {
		return null;
		//return new TextCellEditor((Composite) getViewer().getControl());;
	}
}
