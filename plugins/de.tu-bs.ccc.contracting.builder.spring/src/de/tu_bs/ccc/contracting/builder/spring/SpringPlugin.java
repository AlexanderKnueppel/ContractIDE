package de.tu_bs.ccc.contracting.builder.spring;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.osgi.framework.BundleContext;

import de.tu_bs.ccc.contracting.builder.spring.wizards.DeploymentWizard;

/**
 * The activator class controls the plug-in life cycle
 */
public class SpringPlugin extends de.tu_bs.ccc.contracting.ui.Activator {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.tu-bs.ccc.contracting.builder.spring"; //$NON-NLS-1$

	// The shared instance
	private static SpringPlugin plugin;

	public static final String TEMPLATE_DIR = "template";//$NON-NLS-1$

	/**
	 * The constructor
	 */
	public SpringPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		// new Thread() {

		// @Override
		// public void run() {
		// try {
		// ClassLoader.getSystemClassLoader()
		// .loadClass("de.tu-bs.ccc.contracting.builder.spring.wizards.ProjectProvider");
		// } catch (final ClassNotFoundException e) {
		// SpringPlugin.getDefault().logError(e);
		// }
		// };
		// }.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SpringPlugin getDefault() {
		return plugin;
	}
}
