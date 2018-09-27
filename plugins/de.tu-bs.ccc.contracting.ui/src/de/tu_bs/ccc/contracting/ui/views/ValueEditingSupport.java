package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public class ValueEditingSupport extends EditingSupport {
	
	public ValueEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new TextCellEditor((Composite) getViewer().getControl());
	}

	@Override
	protected boolean canEdit(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		// TODO Auto-generated method stub

	}

}
