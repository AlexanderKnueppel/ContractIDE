package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.jface.viewers.CellEditor;

public class ModulePropertyElement {
	private String attribute = "";
	private String value = "";
	private Object object = null;
	private CellEditor editor = null;
	
	public String getAttribute() {
		return attribute;
	}

	public String getValue() {
		return value;
	}

	public Object getObject() {
		return object;
	}
	
	public CellEditor getCellEditor() {
		return editor;
	}
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public void setCellEditor(CellEditor editor) {
		this.editor = editor;
	}
	
	public ModulePropertyElement(String attr, String value, Object obj, CellEditor editor) {
		this.attribute = attr;
		this.value = value;
		this.object = obj;
		this.editor = editor;
	}
}
