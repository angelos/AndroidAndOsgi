package net.luminis.jfall2012.clockuser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.felix.dm.DependencyManager;
import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.FelixConstants;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class ClockUser extends Activity {
	private Felix m_felix;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clock_user);

		createFramework(new net.luminis.jfall2012.clock.threadbased.Activator());

		ClockTextField textField = (ClockTextField) findViewById(R.id.clockTextField1);
		textField.register(getDependencyManager(), this);
	}
	
	private void createFramework(BundleActivator... activators) {
		try {
			Map<String, Object> config = new HashMap<String, Object>();
			String cache = "/data/data/" + getApplicationContext().getPackageName() + "/cache";
			config.put(Constants.FRAMEWORK_STORAGE, cache);
			
			// We register our activators here
			config.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, Arrays.asList(activators));

			m_felix = new Felix(config);
			m_felix.start();
		} catch (BundleException e) {
			// Alert the proper authorities
		}
	}

	private DependencyManager getDependencyManager() {
		return new DependencyManager(m_felix.getBundleContext());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_clock_user, menu);
		return true;
	}
}
