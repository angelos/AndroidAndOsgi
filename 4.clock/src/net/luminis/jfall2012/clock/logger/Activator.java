package net.luminis.jfall2012.clock.logger;

import net.luminis.jfall2012.clock.ClockListener;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager) throws Exception {
		manager.add(createComponent()
				.setInterface(ClockListener.class.getName(), null)
				.setImplementation(ClockLogger.class));
	}

	@Override
	public void destroy(BundleContext context, DependencyManager manager) throws Exception {
	}

}
