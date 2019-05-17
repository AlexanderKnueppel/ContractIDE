package de.tu_bs.ccc.contracting.core.features.loading;

import java.awt.FileDialog;

import java.awt.Frame;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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

import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.localization.StringTable;
import de.tu_bs.ccc.contracting.core.synchronize.mapping.ProjectMapping;
import windows.Dialog;

public class LoadComponentFeature extends AbstractCreateFeature {

	public LoadComponentFeature(IFeatureProvider fp) {
		super(fp, "Load Module", "Loads modeled Component or Compound");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (!(context.getTargetContainer() instanceof Diagram)) {
			PictogramElement pict = context.getTargetContainer();
			if (!(pict instanceof ContainerShape)) {

				return false;
			}

			EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Compound;
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {
		Frame frame = null;
		FileDialog dialog = new FileDialog(frame, "Ressource", FileDialog.LOAD);
		dialog.setFilenameFilter(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(StringTable.MODEL_FILE_EXTENSION)) {
					return true;
				} else {
					return false;
				}
			}
		});

		dialog.setVisible(true);

		String result = dialog.getDirectory() + dialog.getFile();

		URI uri = URI.createFileURI(result);

		// Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		ResourceSet rSet = getDiagram().eResource().getResourceSet();
		// JOptionPane.showConfirmDialog(null, uri.toString());
		// Map<String, Object> m = reg.getExtensionToFactoryMap();
		// m.put("model", new XMIResourceFactoryImpl());
		final Resource resource = rSet.getResource(uri, true);
		Dialog d = new Dialog(this.createList(resource.getContents()).toArray());
		d.setVisible(true);
		try {
			Component c = (Component) resource.getContents().get(d.getCount());
			Component copy = EcoreUtil.copy(c);
			addGraphicalRepresentation(context, copy);
			PictogramElement pict = context.getTargetContainer();
			Compound x = (Compound) getBusinessObjectForPictogramElement(pict);
			copy.setIsPartOf(x);
			copy.setModule(c);
			x.getConsistsOf().add(copy);

			return new Object[] { copy };
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Compound c = (Compound) resource.getContents().get(d.getCount());
			Compound copy = EcoreUtil.copy(c);
			for (Module m : copy.getConsistsOf()) {
				EcoreUtil.delete(m);
			}
			addGraphicalRepresentation(context, copy);
			PictogramElement pict = context.getTargetContainer();
			Compound x = (Compound) getBusinessObjectForPictogramElement(pict);
			copy.setIsPartOf(x);
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

			return new Object[] { copy };

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	List<String> createList(EList<EObject> list) {
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			try {
				names.add(((Module) list.get(i)).getName() + " " + ((Module) list.get(i)).getVersion());
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return names;

	}
}
