package net.luminis.jfall2012.clock.threadbased;

import net.luminis.jfall2012.clock.provider.ClockListener;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager) throws Exception {
		manager.add(createComponent()
				.setImplementation(ClockThread.class)
				.add(createServiceDependency()
						.setService(ClockListener.class)
						.setCallbacks("listenerAdded", "listenerRemoved")));
	}

	@Override
	public void destroy(BundleContext context, DependencyManager manager) throws Exception {
	}
}
