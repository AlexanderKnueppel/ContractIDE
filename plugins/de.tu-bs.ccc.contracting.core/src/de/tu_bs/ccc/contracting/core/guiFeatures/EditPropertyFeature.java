package de.tu_bs.ccc.contracting.core.guiFeatures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.tu_bs.ccc.contracting.Verification.Assumption;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Guarantee;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.mapping.ProjectMapping;
import de.tu_bs.ccc.contracting.core.windows.EditPropertyDialog;
import windows.EditPropertyWindow;

public class EditPropertyFeature extends AbstractCustomFeature {

	public EditPropertyFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement pes = context.getPictogramElements()[0];

		if (pes != null) {

			Object bo = getBusinessObjectForPictogramElement(pes);
			if (bo instanceof Contract) {
				Contract c = (Contract) bo;
				if (c.getModule().getModule() == null) {
					ret = true;
				}

			}
		}
		return ret;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pes = context.getPictogramElements()[0];
		Contract con = (Contract) getBusinessObjectForPictogramElement(pes);
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
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
			if (ProjectMapping.getMapPro().get(project).getMappingEntry((con).getModule()).size() > 0) {

				MessageBox dialog2 = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
				dialog2.setText("Component already used");
				dialog2.setMessage("This compoent already has instances, do you really want to change its ports?");
				int returnCode = dialog2.open();
				if (returnCode == SWT.CANCEL) {
					return;
				}
			}

		}
		EditPropertyDialog dl = new EditPropertyDialog(null, con);
		if (dl.open() == Window.OK) {

		}

//		EditPropertyWindow win = new EditPropertyWindow(con);
//		win.setVisible(true);
//		if (win.getDelA() != null) {
//			EcoreUtil.delete(win.getDelA());
//		} else if (win.getDelG() != null) {
//			EcoreUtil.delete(win.getDelG());
//		} else if (win.isAs()) {
//			Assumption a = con.getAssumption().get(win.getSelectCount());
//			a.setProperty(win.getPropertyOfSelect());
//			a.setPropertyTipe(win.getTypeofSelect());
//
//		} else if (win.isGa()) {
//			Guarantee g = con.getGuarantee().get(win.getSelectCount());
//			g.setProperty(win.getPropertyOfSelect());
//			g.setPropertyTipe(win.getTypeofSelect());
//		}

		updatePictogramElement(pes);

	}

}
