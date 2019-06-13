package de.tu_bs.ccc.contracting.builder.spring.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.builder.spring.SpringModelBuilder;
import de.tu_bs.ccc.contracting.builder.spring.SpringPlugin;
import de.tu_bs.ccc.contracting.builder.spring.utils.SimpleStructureProvider;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;

public class DeploymentWizard extends Wizard implements IExportWizard, IOverwriteQuery {

	private static final String WIZARD_NAME = "Deployment";
	public static final String WIZARD_ID = "de.tu-bs.ccc.contracting.builder.spring.exportWizard";

	private static final String[] response = new String[] { YES, ALL, NO, NO_ALL, CANCEL };

	private WizardNewProjectCreationPage _pageOne;
	private DeploymentPageSettings _pageTwo; //TODO settings
	private IProject currentProject = null;
	private String _templateProjectPath = "template/project";
	private String _indexFileList = "index.filelist";

	public DeploymentWizard() {
		setWindowTitle(WIZARD_NAME);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		if (selection.getFirstElement() instanceof IAdaptable && selection.getFirstElement() instanceof IProject) {
			currentProject = (IProject) ((IAdaptable) selection.getFirstElement()).getAdapter(IProject.class);
		}
	}

	boolean createProjectStub(IProject project, IProgressMonitor monitor)
			throws InvocationTargetException, InterruptedException, CoreException {
		//
		// if (!project.exists()) {
		// project.create(null);
		// project.open(null);
		// }

		final InputStream inputStream;
		try {
			final URL url = new URL("platform:/plugin/de.tu-bs.ccc.contracting.builder.spring/" + _templateProjectPath
					+ "/" + _indexFileList);
			inputStream = url.openConnection().getInputStream();
		} catch (final IOException e) {
			SpringPlugin.getDefault().logError(e);
			return false;
		}

		final List<String> res = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")))) {
			String line;
			while ((line = br.readLine()) != null) {
				res.add(line);
			}
			new ImportOperation(project.getFullPath(), null, new SimpleStructureProvider(_templateProjectPath), this,
					res).run(monitor);

		} catch (final IOException e) {
			SpringPlugin.getDefault().logError(e);
			return false;
		}
		return true;
	}

	public boolean deployProject(IProject project) {
		try {
			getContainer().run(true, true, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						createProjectStub(project, SubMonitor.convert(monitor, 1));
						modifyPOM(project);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// TODO -> modify project accordingly
					if(currentProject == null)
						return;
					
					try {
						List<Module> modules = (List<Module>) CoreUtil.getRootModules(currentProject);
						new SpringModelBuilder(project, currentProject, modules, new HashMap<String,String>()).buildModel();
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} catch (final InterruptedException e) {
			return false;
		} catch (final InvocationTargetException e) {
			// one of the steps resulted in a core exception
			final Throwable t = e.getTargetException();
			final String message = "";
			IStatus status;
			if (t instanceof CoreException) {
				status = ((CoreException) t).getStatus();
			} else {
				status = new Status(IStatus.ERROR, "org.eclipse.ui.ide", 1, message, t);
			}
			ErrorDialog.openError(getShell(), message, null, status);
			SpringPlugin.getDefault().logError(e);
			return false;
		}
		return true;
	}

	protected void modifyPOM(IProject project) throws UnsupportedEncodingException, CoreException {
		IFile file = project.getFile("pom.xml");
		InputStream inputStream = file.getContents();

		String result = new BufferedReader(new InputStreamReader(inputStream)).lines()
				.collect(Collectors.joining("\n"));

		result = result.replace("{{groupid}}", "de.tu-bs." + project.getName());
		result = result.replace("{{artifactid}}", project.getName());
		result = result.replace("{{snapshot}}", "0.0.1-SNAPSHOT");

		byte[] bytes = result.getBytes(file.getCharset());
		InputStream source = new ByteArrayInputStream(bytes);
		file.setContents(source, IResource.FORCE, null);
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		if (_pageOne.getProjectName() != null) {
			final String projectName = _pageOne.getProjectName();
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			final IProject project = workspace.getRoot().getProject(projectName);

			deployProject(project);

		}
		return true;
	}

	@Override
	public void addPages() {
		super.addPages();

		_pageOne = new WizardNewProjectCreationPage("Deployment");
		_pageOne.setTitle("Deployment to Spring framework");
		_pageOne.setDescription("Deploy components to the spring framework.");

		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		URL url = FileLocator.find(bundle, new Path("icons/icon-spring-framework.png"), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);

		_pageOne.setImageDescriptor(imageDescriptor);
		addPage(_pageOne);
	}

	@Override
	public String queryOverwrite(String pathString) {
		final Path path = new Path(pathString);

		String messageString;
		// Break the message up if there is a file name and a directory
		// and there are at least 2 segments.
		if ((path.getFileExtension() == null) || (path.segmentCount() < 2)) {
			messageString = pathString + " already exists. Would you like to overwrite it?";
		} else {
			messageString = "Overwrite " + path.lastSegment() + " in folder " + path.removeLastSegments(1).toOSString()
					+ " ?";
		}

		final MessageDialog dialog = new MessageDialog(getContainer().getShell(), "Question", null, messageString,
				MessageDialog.QUESTION, new String[] { IDialogConstants.YES_LABEL, IDialogConstants.YES_TO_ALL_LABEL,
						IDialogConstants.NO_LABEL, IDialogConstants.NO_TO_ALL_LABEL, IDialogConstants.CANCEL_LABEL },
				0);

		// run in syncExec because callback is from an operation,
		// which is probably not running in the UI thread.
		_pageOne.getControl().getDisplay().syncExec(new Runnable() {

			@Override
			public void run() {
				dialog.open();
			}
		});

		return dialog.getReturnCode() < 0 ? CANCEL : response[dialog.getReturnCode()];
	}

	public static void openWizard() {
		DeploymentWizard wizard = new DeploymentWizard();

		wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
		WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
		dialog.open();
	}

}
