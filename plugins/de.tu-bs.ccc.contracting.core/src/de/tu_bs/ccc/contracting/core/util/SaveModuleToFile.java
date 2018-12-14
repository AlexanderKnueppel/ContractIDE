package de.tu_bs.ccc.contracting.core.util;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.localization.StringTable;

public class SaveModuleToFile extends RecordingCommand {
	private TransactionalEditingDomain editingDomain;
	private Module module;
	private IFolder folder;
	
	public SaveModuleToFile(TransactionalEditingDomain domain, IFolder folder, Module module) {
		super(domain);
		this.editingDomain = domain;
		this.module = module;
		this.folder = folder;
	}

	@Override
	protected void doExecute() {
		String fileName = module.getName() + "." + StringTable.DIAGRAM_FILE_EXTENSION;

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(folder.getFullPath());

		if (!resource.exists() || !(resource instanceof IContainer)) {
			try {
				throw new Exception("Folder \"" + folder.getName() + "\" does not exist.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		
		System.out.println(file.getName());
		
		String diagramTypeId = "ContractModelling";
		Diagram diagram = Graphiti.getPeCreateService().createDiagram(diagramTypeId, module.getName(), true);
		ResourceSet rSet = editingDomain.getResourceSet();

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
		final Resource resource2 = rSet.getResource(uri, true);

		resource2.getContents().add(diagram);
		resource2.getContents().add(MmFactory.eINSTANCE.createComponent());
		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram,
				"ContractModelling.ContractModellingDiagramTypeProvider"); //$NON-NLS-1$
		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		AddContext create = new AddContext();

		int dot = file.getName().lastIndexOf(".");

		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model");
		final IFile domainfile = container.getFile(new Path(file.getName().substring(0, dot) + ".model"));
		if (domainfile == null || !domainfile.exists()) {
			Resource createResource = rSet.createResource(uri);
			try {
				createResource.save(new HashMap());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			createResource.setTrackingModification(true);

		}

		create.setNewObject(module);
		final Resource resourceDomain = rSet.getResource(uri, true);
		resourceDomain.getContents().add(module);
		try {
			resourceDomain.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		create.setTargetContainer(diagram);

		create.setX(100);
		create.setY(100);
		create.setSize(200, 200);
		IAddFeature add = featureProvider.getAddFeature(create);

		if (add.canAdd(create)) {
			add.add(create);
		}
		
		UpdateContext updateContext = new UpdateContext(diagram.getChildren().get(0));
		IUpdateFeature updateFeature = dtp.getFeatureProvider().getUpdateFeature(updateContext);
		updateFeature.update(updateContext);

		try {
			resource2.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
