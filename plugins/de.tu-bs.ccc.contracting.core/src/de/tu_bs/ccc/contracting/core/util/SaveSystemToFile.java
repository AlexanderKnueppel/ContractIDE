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
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.localization.StringTable;

public class SaveSystemToFile extends RecordingCommand {
	private TransactionalEditingDomain editingDomain;
	private System system;
	private IFolder folder;

	public SaveSystemToFile(TransactionalEditingDomain domain, IFolder folder, System system) {
		super(domain);
		this.editingDomain = domain;
		this.system = system;
		this.folder = folder;
	}

	@Override
	protected void doExecute() {
		String fileName = system.getName() + "." + StringTable.DIAGRAM_FILE_EXTENSION;

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(folder.getFullPath());

		if (!resource.exists() || !(resource instanceof IContainer)) {
			try {
				throw new Exception("Folder \"" + folder.getName() + "\" does not exist.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));

		String diagramTypeId = "ContractModelling";
		Diagram diagram = Graphiti.getPeCreateService().createDiagram(diagramTypeId, system.getName(), true);
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

		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram,
				"ContractModelling.ContractModellingDiagramTypeProvider"); //$NON-NLS-1$
		IFeatureProvider featureProvider = dtp.getFeatureProvider();

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

		// Save .model-file
		final Resource resourceDomain = rSet.getResource(uri, true);
		resourceDomain.getContents().add(system);
		try {
			resourceDomain.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Build graphical representation
		AddContext create = new AddContext();
		create.setNewObject(system);
		create.setTargetContainer(diagram);
		create.setX(100);
		create.setY(100);
		create.setSize(200, 200);

		IAddFeature add = featureProvider.getAddFeature(create);
		if (add.canAdd(create)) {
			add.add(create);
		}

		for (Module child : system.getConsistsOf()) {
			create.setNewObject(child);
			create.setTargetContainer((ContainerShape) featureProvider.getPictogramElementForBusinessObject(system));
			create.setX(50);
			create.setY(50);
			create.setSize(100, 100);
			add = featureProvider.getAddFeature(create);

			if (add.canAdd(create)) {
				add.add(create);
			}
		}

		// Connections
//		for (Module child : system.getConsistsOf()) {
//			for (Ports port : child.getPorts()) {
//				if (port.getOuterDirection() == DirectionType.INTERNAL && port.getPortseOpposite() != null) {
//					Ports from = port.getPortseOpposite();
//					ContainerShape fromContainer = (ContainerShape) featureProvider
//							.getPictogramElementForBusinessObject(from);
//					ContainerShape toContainer = (ContainerShape) featureProvider
//							.getPictogramElementForBusinessObject(port);
//					AddContext createConnection = new AddConnectionContext(fromContainer.getAnchors().get(0),
//							toContainer.getAnchors().get(0));
//
//					add = featureProvider.getAddFeature(createConnection);
//					if (add.canAdd(createConnection)) {
//						add.add(createConnection);
//					}
//				}
//			}
//		}

		try {
			resource2.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
