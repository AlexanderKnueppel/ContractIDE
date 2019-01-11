package de.tu_bs.ccc.contracting.examples;

import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 *
 * @author Alexander Knueppel
 */
public class ExamplePlugin extends de.tu_bs.ccc.contracting.ui.Activator {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.tu-bs.ccc.contracting.examples"; //$NON-NLS-1$

	// The shared instance
	private static ExamplePlugin plugin;

	public static final String EXAMPLE_DIR = "examples";//$NON-NLS-1$
	public static final String EXAMPLE_INDEX = "projects.xml";//$NON-NLS-1$
	
	/**
	 * The constructor
	 */
	public ExamplePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		new Thread() {

			@Override
			public void run() {
				try {
					ClassLoader.getSystemClassLoader().loadClass("de.tu-bs.ccc.contracting.examples.wizards.ProjectProvider");
				} catch (final ClassNotFoundException e) {
					ExamplePlugin.getDefault().logError(e);
				}
			};
		}.start();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	public static ExamplePlugin getDefault() {
		return plugin;
	}
	
	@Override
	public String getID() {
		return ExamplePlugin.PLUGIN_ID;
	}

}
