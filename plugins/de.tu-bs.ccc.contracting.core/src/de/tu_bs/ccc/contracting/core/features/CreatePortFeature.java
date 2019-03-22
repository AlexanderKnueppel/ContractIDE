package de.tu_bs.ccc.contracting.core.features;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.ProviderType;
import de.tu_bs.ccc.contracting.core.mapping.ComponentmportMapping;
import de.tu_bs.ccc.contracting.core.mapping.ProjectMapping;
import de.tu_bs.ccc.contracting.Verification.MmFactory;

public class CreatePortFeature extends AbstractCreateFeature implements ICreateFeature {
	public static final PortType pt = PortType.STRING;

	public CreatePortFeature(IFeatureProvider fp) {
		super(fp, "Port", "Adds a Port to a Module");
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

			return businessObjects.size() == 1 && businessObjects.get(0) instanceof Module;
		} else {
			return false;
		}
	}

	@Override
	public Object[] create(ICreateContext context) {
		PictogramElement pict = context.getTargetContainer();
		EList<EObject> businessObjects = pict.getLink().getBusinessObjects();
		if (businessObjects.get(0) instanceof Module) {
			Module m = (Module) businessObjects.get(0);
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage activePage = window.getActivePage();

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
				if (ProjectMapping.getMapPro().get(project).getMappingEntry(m).size() != 0) {

					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					MessageDialog dialog = new MessageDialog(shell, "Componetent already instanced", null,
							"You can not add ports to an component with instances!", MessageDialog.INFORMATION,
							new String[] { "OK" }, 0);
					dialog.open();
					return null;
				}

			}
		}
		Ports addedObject = MmFactory.eINSTANCE.createPorts();

		addedObject.setType(pt);
		Module expandWithPort = ((Module) businessObjects.get(0));
		String classname = "port" + expandWithPort.getPorts().size();
		addedObject.setName(classname);

		addedObject.setLabel("");
		addedObject.setFunction("");
		addedObject.setFilter("");
		addedObject.setProviderType(ProviderType.NATIVE);
		addedObject.setMaxClients(-1);

		expandWithPort.getPorts().add(addedObject);
		AddContext contextAdd = new AddContext(context, addedObject);
		contextAdd.setTargetContainer(context.getTargetContainer());
		addGraphicalRepresentation(contextAdd, addedObject);

//		 try {
//		 SaveDomainModel.saveToModelFile(addedObject, getDiagram());
//		 } catch (CoreException | IOException e) {
//		 JOptionPane.showConfirmDialog(null, "Fehler");
//		 }
		return new Object[] { addedObject };
	}

}
