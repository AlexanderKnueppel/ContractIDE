package de.tu_bs.ccc.contracting.core.features.loading;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.features.layout.LayoutDiagramFeature;
import de.tu_bs.ccc.contracting.core.localization.StringTable;
import de.tu_bs.ccc.contracting.core.synchronize.mapping.ProjectMapping;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.ui.dialogs.LoadModuleDialog;
import de.tu_bs.ccc.contracting.ui.provider.LoadModuleLabelProvider;

public class LoadModuleFeature extends AbstractCreateFeature {

	public LoadModuleFeature(IFeatureProvider fp) {
		super(fp, StringTable.LOAD_MODULE_SHORT, StringTable.LOAD_MODULE);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {
				return false;
			}

			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1
					&& (businessObjects.get(0) instanceof Compound || businessObjects.get(0) instanceof System);
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {

		List<Module> modules = (List<Module>) CoreUtil.getRootModules(CoreUtil.getCurrentProject(), m -> {
			PictogramElement pict = context.getTargetContainer();
			EObject x = (EObject) getBusinessObjectForPictogramElement(pict);

			return !x.eResource().getURI().toString().equals(m.eResource().getURI().toString());
		});

		final LoadModuleDialog dialog = new LoadModuleDialog(null, new LoadModuleLabelProvider(),
				"Add Module to this Container", "Add Module", modules);

		if (dialog.open() == LoadModuleDialog.CANCEL) {
			return null;
		}

		for (Object obj : dialog.getResult()) {
			Module c = (Module) obj;
			Module copy = EcoreUtil.copy(c);

			if (copy instanceof Compound) {
				EcoreUtil.deleteAll(((Compound) copy).getConsistsOf(), true);
			}

			addGraphicalRepresentation(context, copy);
			PictogramElement pict = context.getTargetContainer();
			
			Object container = getBusinessObjectForPictogramElement(pict);
			if (container instanceof Compound) {
				Compound x = (Compound) getBusinessObjectForPictogramElement(pict);
				copy.setIsPartOf(x);
				copy.getRealizedBy().addAll(c.getRealizedBy());
				copy.setModule(c);
				x.getConsistsOf().add(copy);
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
							ProjectMapping.getMapPro().get(project).addMappingEntry(c, copy);
						}
					}
				}

			} else if (container instanceof System) {
				System x = (System) getBusinessObjectForPictogramElement(pict);
				copy.setModule(c);
				copy.getRealizedBy().addAll(c.getRealizedBy());
				copy.setIsPartOf(null);
				x.getConsistsOf().add(copy);
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
							ProjectMapping.getMapPro().get(project).addMappingEntry(c, copy);
						}
					}
				}

			}

			new LayoutDiagramFeature(getFeatureProvider())
					.layoutAtomic((ContainerShape) getFeatureProvider().getPictogramElementForBusinessObject(copy));

			return new Object[] { copy };
		}

		return null;
	}
}
