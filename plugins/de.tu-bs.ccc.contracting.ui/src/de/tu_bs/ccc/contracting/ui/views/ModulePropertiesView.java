package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ModulePropertiesView extends ViewPart {

	private TreeViewer viewer;

	public TreeViewer getViewer() {
		return viewer;
	}

	@Override
	public void createPartControl(Composite parent) {

		viewer = new TreeViewer(parent, SWT.FULL_SELECTION);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);

		TreeViewerColumn columnSkill = new TreeViewerColumn(viewer, SWT.NONE);
		columnSkill.getColumn().setWidth(250);
		columnSkill.getColumn().setText("Attribute");

		TreeViewerColumn columnTerm = new TreeViewerColumn(viewer, SWT.NONE);
		columnTerm.getColumn().setWidth(250);
		columnTerm.getColumn().setText("Value");
		columnTerm.setEditingSupport(new ValueEditingSupport(viewer));

		viewer.setContentProvider(new ModulePropertiesContentProvider(viewer));
		viewer.setLabelProvider(new ModulePropertiesLabelProvider());

		GridLayoutFactory.fillDefaults().generateLayout(parent);
	}

	@Override
	public void setFocus() {

	}

}