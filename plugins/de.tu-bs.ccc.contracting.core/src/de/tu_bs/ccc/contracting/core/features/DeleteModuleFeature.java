package de.tu_bs.ccc.contracting.core.features;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.mapping.ProjectMapping;

public class DeleteModuleFeature extends DefaultDeleteFeature {

	public DeleteModuleFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(IDeleteContext context) {
		PictogramElement pes = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pes);
		Module m = (Module) bo;
		if (m.getModule()!=null) {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage activePage = window.getActivePage();

			IEditorPart activeEditor = activePage.getActiveEditor();

			if (activeEditor != null) {
				IEditorInput input = activeEditor.getEditorInput();

				IProject project = input.getAdapter(IProject.class);
				if (project == null) {
					IResource resource2 = input.getAdapter(IResource.class);
					if (resource2 != null) {
						project = resource2.getProject();
						ProjectMapping.getMapPro().get(project).deleteMappingEntry(m);
					}
				}
			}

		}
		super.delete(context);
	}

}
