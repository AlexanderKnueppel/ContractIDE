package de.tu_bs.ccc.contracting.ui.wizards;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
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
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.MmFactory;


public class CreateModule extends RecordingCommand {
	private TransactionalEditingDomain editingDomain;
	private String diagramName;
	private URI path;
	private String containerName;
	private CreationType type;
	

	public CreateModule(TransactionalEditingDomain domain, String containerName, String name, URI path, CreationType type) {
		super(domain);
		this.type = type;
		this.editingDomain = domain;
		this.diagramName = name;
		this.path = path;
		this.containerName = containerName;

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doExecute() {
		String diagramTypeId = "ContractModelling";
		Diagram diagram = Graphiti.getPeCreateService().createDiagram(diagramTypeId, this.diagramName, true);
		ResourceSet rSet = editingDomain.getResourceSet();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {

		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(diagramName));

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
		AddContext creat = new AddContext();
		
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
		if(this.type == CreationType.COMPONENT) {
		Component c = MmFactory.eINSTANCE.createComponent();
		c.setName(file.getName().substring(0, dot));
		c.setModule(null);
		creat.setNewObject(c);
		final Resource resourceDomain = rSet.getResource(uri, true);
		resourceDomain.getContents().add(c);
		try {
			resourceDomain.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		} else if (this.type == CreationType.COMPOUND) {
			 de.tu_bs.ccc.contracting.Verification.Compound c = MmFactory.eINSTANCE.createCompound();
			creat.setNewObject(c);
			c.setName(file.getName().substring(0, dot));
			c.setModule(null);
			final Resource resourceDomain = rSet.getResource(uri, true);
			resourceDomain.getContents().add(c);
			try {
				resourceDomain.save(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		creat.setTargetContainer(diagram);

		creat.setX(100);
		creat.setY(100);
		creat.setSize(200, 200);
		IAddFeature add = featureProvider.getAddFeature(creat);
		PictogramLink link = PictogramsFactory.eINSTANCE.createPictogramLink();
		
		//diagram.setLink(link);
		//link.getBusinessObjects().add(c);
		if (add.canAdd(creat)) {
			add.add(creat);
		}

		try {
			resource2.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
