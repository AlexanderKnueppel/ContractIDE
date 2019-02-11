package de.tu_bs.ccc.contracting.core.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.localization.StringTable;
import de.tu_bs.ccc.contracting.ui.wizards.CreationType;

public class CoreUtil {

	public static IProject getCurrentProject() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage activePage = window.getActivePage();

		IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
		if (!selection.isEmpty()) {
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof IAdaptable && firstElement instanceof IProject) {
				return (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
			}
		}

		IEditorPart activeEditor = activePage.getActiveEditor();

		if (activeEditor != null) {
			IEditorInput input = activeEditor.getEditorInput();

			IProject project = input.getAdapter(IProject.class);
			if (project == null) {
				IResource resource = input.getAdapter(IResource.class);
				if (resource != null) {
					project = resource.getProject();
				}
			}
			return project;
		}

		return null;
	}

	public static Collection<Module> getRootModules(IProject p) {
		return getRootModules(p, new ModuleFilter() {
			@Override
			public boolean keep(Module m) {
				return true;
			}

		});
	}

	public static Collection<Module> getRootModules(IProject p, ModuleFilter filter) {
		final List<IFile> files = getModelFiles(p);
		final List<Module> moduleList = new ArrayList<Module>();
		final ResourceSet rSet = new ResourceSetImpl();
		for (final IFile file : files) {
			final Module module = getRootModuleFromFile(file, rSet);
			if (module != null && filter.keep(module)) {
				moduleList.add(module);
			}
		}
		return moduleList;
	}

	public static List<IFile> getModelFiles(IContainer folder) {
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					ret.addAll(getModelFiles((IContainer) resource));
				} else if (resource instanceof IFile) {
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(StringTable.MODEL_FILE_EXTENSION)) {
						ret.add(file);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static Module getRootModuleFromFile(IFile file, ResourceSet resourceSet) {
		// Get the URI of the model file.
		final URI resourceURI = getFileURI(file, resourceSet);
		// Demand load the resource for this file.
		Resource resource;
		try {
			resource = resourceSet.getResource(resourceURI, true);
			if (resource != null) {
				// does resource contain a diagram as root object?
				final EObject root = resource.getContents().get(0);
				if (root instanceof Module) {
					return (Module) root;
				}
			}
		} catch (final WrappedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static System getRootSystemFromFile(IFile file, ResourceSet resourceSet) {
		// Get the URI of the model file.
		final URI resourceURI = getFileURI(file, resourceSet);
		// Demand load the resource for this file.
		Resource resource;
		try {
			resource = resourceSet.getResource(resourceURI, true);
			if (resource != null) {
				// does resource contain a diagram as root object?
				final EObject root = resource.getContents().get(0);
				if (root instanceof System) {
					return (System) root;
				}
			}
		} catch (final WrappedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Collection<Diagram> getDiagrams(IProject p) {
		final List<IFile> files = getDiagramFiles(p);
		final List<Diagram> diagramList = new ArrayList<Diagram>();
		final ResourceSet rSet = new ResourceSetImpl();
		for (final IFile file : files) {
			final Diagram diagram = getDiagramFromFile(file, rSet);
			if (diagram != null) {
				diagramList.add(diagram);
			}
		}
		return diagramList;
	}

	private static List<IFile> getDiagramFiles(IContainer folder) {
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					ret.addAll(getDiagramFiles((IContainer) resource));
				} else if (resource instanceof IFile) {
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(StringTable.DIAGRAM_FILE_EXTENSION)) {
						ret.add(file);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static Diagram getDiagramFromFile(IFile file, ResourceSet resourceSet) {
		// Get the URI of the model file.
		final URI resourceURI = getFileURI(file, resourceSet);
		// Demand load the resource for this file.
		Resource resource;
		try {
			resource = resourceSet.getResource(resourceURI, true);
			if (resource != null) {
				// does resource contain a diagram as root object?
				final EList<EObject> contents = resource.getContents();
				for (final EObject object : contents) {
					if (object instanceof Diagram) {
						return (Diagram) object;
					}
				}
			}
		} catch (final WrappedException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static URI getFileURI(IFile file, ResourceSet resourceSet) {
		final String pathName = file.getFullPath().toString();
		URI resourceURI = URI.createFileURI(pathName);
		resourceURI = resourceSet.getURIConverter().normalize(resourceURI);
		return resourceURI;
	}

	public static void createDiagramFile(IFolder location, Module m) throws Exception {
		String filename = m.getName() + "." + StringTable.DIAGRAM_FILE_EXTENSION;

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(location.getFullPath());

		if (!resource.exists() || !(resource instanceof IContainer)) {
			throw new Exception("Folder \"" + location.getName() + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(filename));

		ResourceSet rSet = new ResourceSetImpl();
		URI uri = URI.createFileURI(file.getFullPath().toString());

		if (file == null || !file.exists()) {
			Resource createResource = rSet.createResource(uri);
			try {
				createResource.save(new HashMap());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			createResource.setTrackingModification(true);

		}

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(rSet);
		if (editingDomain == null) {
			// Not yet existing, create one
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rSet);
		}

		String diagramTypeId = "ContractModelling";
		Diagram diagram = Graphiti.getPeCreateService().createDiagram(diagramTypeId, filename, true);

		final Resource res = editingDomain.getResourceSet().createResource(uri);
		res.getContents().add(diagram);
		res.getContents().add(m);

		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram,
				"ContractModelling.ContractModellingDiagramTypeProvider"); //$NON-NLS-1$

		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		AddContext context = new AddContext();

		context.setTargetContainer(diagram);

		context.setX(100);
		context.setY(100);
		context.setSize(200, 200);

		IAddFeature add = featureProvider.getAddFeature(context);
		// PictogramLink link = PictogramsFactory.eINSTANCE.createPictogramLink();

		if (add.canAdd(context)) {
			add.add(context);
		}

		try {
			res.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * States whether a Component(Instance) needs to be synched with its original
	 * 
	 * @param copy the instance/copy component
	 * @return whether copy is not synched
	 */
	public static boolean isComponentNotSynched(Module copy) {
		boolean synch = false;
		try {
			if (!copy.getName().equals(copy.getModule().getName())) {
				synch = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (!copy.getDescription().equals(copy.getModule().getDescription())) {
				synch = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (!copy.getCaps().equals(copy.getModule().getCaps())) {
				synch = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (!copy.getRam().equals(copy.getModule().getRam())) {
				synch = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (!copy.getSpec().equals(copy.getModule().getSpec())) {
				synch = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (!copy.getRte().equals(copy.getModule().getRte())) {
				synch = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; (i < copy.getPorts().size() && i < copy.getModule().getPorts().size()); i++) {


			if (!copy.getPorts().get(i).getName().equals(copy.getModule().getPorts().get(i).getName())) {

				synch = true;
			}
			if (copy.getPorts().get(i).getMaxClients() != copy.getModule().getPorts().get(i).getMaxClients()) {

				synch = true;
			}
			if (!copy.getPorts().get(i).getLabel().equals(copy.getModule().getPorts().get(i).getLabel())) {

				synch = true;
			}
			if (!copy.getPorts().get(i).getService().equals(copy.getModule().getPorts().get(i).getService())) {

				synch = true;
			}
		}
		return synch;

	}
}