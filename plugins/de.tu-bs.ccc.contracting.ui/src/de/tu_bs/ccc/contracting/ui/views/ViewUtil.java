package de.tu_bs.ccc.contracting.ui.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;

public class ViewUtil {
	public static void updateViews(EObject obj) {
		IViewReference[] ref = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
		for (IViewReference iViewReference : ref) {
			if (iViewReference.getId().equals("contractide.views.moduleproperties")) {// TODO rework, bit too hacky
				TreeViewer view = ((ModulePropertiesView) iViewReference.getView(true)).getViewer();
				if (view.getInput() == null || !view.getInput().equals(obj)) {
					view.setInput(obj);
				}
				view.refresh();
			} 
		}
	}
}
