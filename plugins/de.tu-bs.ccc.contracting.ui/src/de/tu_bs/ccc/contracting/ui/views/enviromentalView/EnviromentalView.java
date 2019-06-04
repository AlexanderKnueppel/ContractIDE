package de.tu_bs.ccc.contracting.ui.views.enviromentalView;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.Property;

public class EnviromentalView extends ViewPart {

	private TableViewer viewer;

	public TableViewer getViewer() {
		return viewer;
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.FULL_SELECTION);
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);

		TableViewerColumn columnName = new TableViewerColumn(viewer, SWT.NONE);
		columnName.getColumn().setWidth(200);
		columnName.getColumn().setText("Name");
		columnName.setEditingSupport(new NameEditingSupport(viewer));

		TableViewerColumn columnValue = new TableViewerColumn(viewer, SWT.NONE);
		columnValue.getColumn().setWidth(100);
		columnValue.getColumn().setText("Type");
		columnValue.setEditingSupport(new TypeEditingSupport(viewer));

		TableViewerColumn columnDefaultValue = new TableViewerColumn(viewer, SWT.NONE);
		columnDefaultValue.getColumn().setWidth(300);
		columnDefaultValue.getColumn().setText("Value [range]");
		columnDefaultValue.setEditingSupport(new ValueEditingSupport(viewer));

//		TableViewerColumn columnIsVariable = new TableViewerColumn(viewer, SWT.NONE);
//		columnIsVariable.getColumn().setWidth(50);
//		columnIsVariable.getColumn().setText("var");
//		columnIsVariable.setEditingSupport(new IsVariableEditingSupport(viewer));

		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new LabelProvider());

		Button button = new Button(parent, SWT.NONE);
		button.setText("Add new parameter");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Property parameter = MmFactory.eINSTANCE.createProperty();
				parameter.setName("Acceleration");
				parameter.setValue("a");
				parameter.setType("String");
				Module mod = null;
				if (viewer.getInput() instanceof Module) {
					mod = ((Module) viewer.getInput());
				}
				if (viewer.getInput() instanceof Ports) {
					mod = ((Ports) viewer.getInput()).getModule();
				}
				final Module mod2 = mod;
				try {

					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(mod);
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {
							mod2.getEnviromentalProperties().add(parameter);
						}
					});
				} catch (Exception e2) {
					// TODO: handle exception
				}
				viewer.refresh();
			}
		});

		MenuManager manager = new MenuManager();
		viewer.getControl().setMenu(manager.createContextMenu(viewer.getControl()));
		manager.add(new Action("Delete Parameter") {
			@Override
			public void run() {
				Property deletParameter = (Property) viewer.getStructuredSelection().getFirstElement();
				Module mod = null;
				if (viewer.getInput() instanceof Module) {
					mod = ((Module) viewer.getInput());
				}
				if (viewer.getInput() instanceof Ports) {
					mod = ((Ports) viewer.getInput()).getModule();
				}
				final Module mod2 = mod;
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(mod);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						mod2.getEnviromentalProperties().remove(deletParameter);
					}
				});
				viewer.refresh();
			}
		});

		GridLayoutFactory.fillDefaults().generateLayout(parent);
	}

	@Override
	public void setFocus() {
	}

}
