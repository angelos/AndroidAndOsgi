package net.luminis.jfall2012.basic;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.framework.Felix;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class BasicFramework extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_framework);

		try {
// Create and start a framework
Map<String, Object> config = new HashMap<String, Object>();
String cache = "/data/data/" + getApplicationContext().getPackageName() + "/cache";
config.put(Constants.FRAMEWORK_STORAGE, cache);
Felix felix = new Felix(config);
felix.start();

// Get to the bundle context
BundleContext context = felix.getBundleContext();

// Print something that shows we have a framework
Log.d("JFall2012",
		context.getProperty(Constants.FRAMEWORK_VENDOR)
		);
		} catch (BundleException e) {
			// If this happens, remember to clean up nicely.
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_basic_framework, menu);
		return true;
	}
}
