package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.LabelProvider;
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
//
//		TreeViewerColumn columnComment = new TreeViewerColumn(viewer, SWT.NONE);
//		columnComment.getColumn().setWidth(600);
//		columnComment.getColumn().setText("Comment");
//		columnComment.setEditingSupport(new CommentEditingSupport(viewer));
//
//		TreeViewerColumn columnType = new TreeViewerColumn(viewer, SWT.NONE);
//		columnType.getColumn().setWidth(50);
//		columnType.getColumn().setText("Type");
//		columnType.setEditingSupport(new TypeEditingSupport(viewer));
//
		viewer.setContentProvider(new ModulePropertiesContentProvider());
		viewer.setLabelProvider(new ModulePropertiesLabelProvider());

//		MenuManager manager = new MenuManager();
//		viewer.getControl().setMenu(manager.createContextMenu(viewer.getControl()));
//		manager.add(new Action("Delete Requirement") {
//
//			@Override
//			public void run() {
//				if (viewer.getStructuredSelection().getFirstElement() instanceof Requirement) {
//					Requirement deletReq = (Requirement) viewer.getStructuredSelection().getFirstElement();
//					Node node = deletReq.getNode();
//					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(node);
//					domain.getCommandStack().execute(new RecordingCommand(domain) {
//						@Override
//						protected void doExecute() {
//							node.getRequirements().remove(deletReq);
//						}
//					});
//				}
//				viewer.refresh();
//			}
//		});

		GridLayoutFactory.fillDefaults().generateLayout(parent);
	}

	@Override
	public void setFocus() {

	}

}