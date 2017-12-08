package net.bergertom.rcpdemo.gui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "net.bergertom.rcpdemo;.gui"; //$NON-NLS-1$

	private static Activator plugin;
	

	public Activator() {
	}

	@Override
	public void startup() throws CoreException {

	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

}
