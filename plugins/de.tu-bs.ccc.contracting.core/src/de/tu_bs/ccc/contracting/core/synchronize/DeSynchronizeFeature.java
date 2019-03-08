package de.tu_bs.ccc.contracting.core.synchronize;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.diagram.ContractModellingImageProvider;
import de.tu_bs.ccc.contracting.core.mapping.ProjectMapping;

public class DeSynchronizeFeature extends AbstractCustomFeature {

	public DeSynchronizeFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription();
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement pes = context.getPictogramElements()[0];
		if (pes != null) {
			Object bo = getBusinessObjectForPictogramElement(pes);
			if (bo instanceof Module) {
				Module m = (Module) bo;
				return m.getModule()!=null;
			}
		}
		return ret;
	}

	@Override
	public boolean isAvailable(IContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getImageId() {
		return ContractModellingImageProvider.IMG_DESYNCHRONIZE;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pes = context.getPictogramElements()[0];
		Object bo = getBusinessObjectForPictogramElement(pes);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		Module m = (Module) bo;
		MessageBox dialog2 = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		dialog2.setText("Delete Connection to Instance");
		dialog2.setMessage(
				"Do you want to delete the link from the Component to its original and turn it into a copy?");
		int n = dialog2.open();
		if (n == SWT.YES) {
			m.setModule(null);
			
			IWorkbenchWindow window = PlatformUI.getWorkbench()
		            .getActiveWorkbenchWindow();
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
				   ProjectMapping.getMapPro().get(project).deleteMappingEntry(m);
				   }
			
		}
		updatePictogramElement(pes);
		refresh();

	}
	public static void refresh() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
				decoratorManager.update("de.tubs.ccc.contracting.core.decorators.SynchronizeDecorator");
			}
		});
	}

}
