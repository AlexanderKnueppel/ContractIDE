package de.tu_bs.ccc.contracting.ui.views.verification;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;

import de.tu_bs.ccc.contracting.Verification.ViewPoint;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement.Property;

public class VerificationView extends ViewPart {

	private TreeViewer viewer;

	public TreeViewer getViewer() {
		return viewer;
	}

	public ArrayList<VerificationTopElement> getDummyElements() {
		ArrayList<VerificationViewElement> elements = new ArrayList<VerificationViewElement>();
		ArrayList<VerificationTopElement> top = new ArrayList<VerificationTopElement>();

		elements.add(new VerificationViewElement(ViewPoint.FUNCTIONAL_VALUE, "Dummy Clause 1", "DISPLAY", null,
				VerificationViewElement.Result.SUCCESS, Property.WELLFORMEDNESS));
		elements.add(new VerificationViewElement(ViewPoint.FUNCTIONAL_VALUE, "Dummy Clause", "DISPLAY", null,
				VerificationViewElement.Result.SUCCESS, Property.REALIZABILITY));
		top.add(new VerificationTopElement((ArrayList<VerificationViewElement>) elements.clone()));
		elements.clear();

		elements.add(new VerificationViewElement(ViewPoint.MEMORY_VALUE, "Dummy Clause 2", "Sensor1", null,
				VerificationViewElement.Result.SUCCESS, Property.REALIZABILITY));
		top.add(new VerificationTopElement((ArrayList<VerificationViewElement>) elements.clone()));
		elements.clear();

		elements.add(new VerificationViewElement(ViewPoint.TIMING_VALUE, "Dummy Clause 3", "HighPerfSensor", null,
				VerificationViewElement.Result.SUCCESS, Property.SUBSTITUTABILITY));
		top.add(new VerificationTopElement((ArrayList<VerificationViewElement>) elements.clone()));
		elements.clear();

		return top;
	}

	@Override
	public void createPartControl(Composite parent) {

		viewer = new TreeViewer(parent, SWT.FULL_SELECTION);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);

		TreeViewerColumn columnRes = new TreeViewerColumn(viewer, SWT.NONE);
		columnRes.getColumn().setWidth(60);
		columnRes.getColumn().setText("Result"); // Result

		TreeViewerColumn columnComp = new TreeViewerColumn(viewer, SWT.NONE);
		columnComp.getColumn().setWidth(250);
		columnComp.getColumn().setText("Component");

		TreeViewerColumn columnVP = new TreeViewerColumn(viewer, SWT.NONE);
		columnVP.getColumn().setWidth(250);
		columnVP.getColumn().setText("Viewpoint");
		
		TreeViewerColumn columnProperty = new TreeViewerColumn(viewer, SWT.NONE);
		columnProperty.getColumn().setWidth(250);
		columnProperty.getColumn().setText("Property");

		TreeViewerColumn columnClause = new TreeViewerColumn(viewer, SWT.NONE);
		columnClause.getColumn().setWidth(250);
		columnClause.getColumn().setText("Clause");

		viewer.setContentProvider(new VerificationViewContentProvider(viewer));
		viewer.setLabelProvider(new VerificationViewLabelProvider());

		GridLayoutFactory.fillDefaults().generateLayout(parent);

		viewer.setInput(getDummyElements());
		viewer.refresh();

		viewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				Object ob = event.getSelection();
				if (ob instanceof TreeSelection
						&& ((TreeSelection) ob).getFirstElement() instanceof VerificationViewElement) {
					VerificationViewElement vve = (VerificationViewElement) ((TreeSelection) ob).getFirstElement();
					new VerificationResultDialog(Display.getDefault().getActiveShell(), vve).open();
				}
			}
		});

		// Restore state from the previous session.
		// restoreState();
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

}