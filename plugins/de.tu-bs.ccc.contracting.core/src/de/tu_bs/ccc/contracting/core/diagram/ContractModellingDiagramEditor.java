package de.tu_bs.ccc.contracting.core.diagram;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.ui.views.ViewUtil;

public class ContractModellingDiagramEditor extends DiagramEditor {
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) selection;
			if (!sel.isEmpty() && sel.getFirstElement() instanceof GraphitiShapeEditPart) {
				GraphitiShapeEditPart ep = (GraphitiShapeEditPart) sel.getFirstElement();
				if (ep.getPictogramElement() instanceof PictogramElement) {
					PictogramElement pe = ep.getPictogramElement();
					if (pe.getLink() != null) {
						if (pe.getLink().getBusinessObjects().size() == 1)
							if (pe.getLink().getBusinessObjects().get(0) instanceof Module
									|| pe.getLink().getBusinessObjects().get(0) instanceof Ports)
								ViewUtil.updateViews(pe.getLink().getBusinessObjects().get(0));
							else
								ViewUtil.updateViews(null);
					} else {
						ViewUtil.updateViews(null);
					}
					getDiagramBehavior().refreshPalette();
				}
			}
		}
	}
}
