package net.luminis.jfall2012.user;

import java.io.File;
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

public class MainActivity extends Activity {
	
	private static final String SYSTEM_PACKAGES = "org.osgi.framework.startlevel;uses:=\"org.osgi.framework\";version=\"1.0\"," + 
			"org.osgi.framework.wiring;uses:=\"org.osgi.framework\";version=\"1.0\"," + 
			"org.osgi.service.url;version=\"1.0\"," + 
			"org.osgi.framework.hooks.bundle;uses:=\"org.osgi.framework\";version=\"1.0\"," + 
			"org.osgi.service.packageadmin;uses:=\"org.osgi.framework\";version=\"1.2\"," + 
			"org.osgi.framework.hooks.service;uses:=\"org.osgi.framework\";version=\"1.1\"," + 
			"org.osgi.framework.hooks.resolver;uses:=\"org.osgi.framework.wiring\";version=\"1.0\"," + 
			"org.osgi.service.startlevel;uses:=\"org.osgi.framework\";version=\"1.1\"," + 
			"org.osgi.framework.launch;uses:=\"org.osgi.framework\";version=\"1.0\"," + 
			"org.osgi.util.tracker;uses:=\"org.osgi.framework\";version=\"1.5\"," + 
			"org.osgi.framework;version=\"1.6\"," + 
			"org.osgi.framework.hooks.weaving;uses:=\"org.osgi.framework.wiring\";version=\"1.0\"," + 
			"android," + 
			"android.accessibilityservice" + 
			"android.accounts," + 
			"android.animation," + 
			"android.app," + 
			"android.app.admin," + 
			"android.app.backup," + 
			"android.appwidget," + 
			"android.bluetooth," + 
			"android.content," + 
			"android.content.pm," + 
			"android.content.res," + 
			"android.database," + 
			"android.database.sqlite," + 
			"android.drm," + 
			"android.gesture," + 
			"android.graphics," + 
			"android.graphics.drawable," + 
			"android.graphics.drawable.shapes," + 
			"android.hardware," + 
			"android.hardware.usb," + 
			"android.inputmethodservice," + 
			"android.location," + 
			"android.media," + 
			"android.media.audiofx," + 
			"android.mtp," + 
			"android.net," + 
			"android.net.http," + 
			"android.net.rtp," + 
			"android.net.sip," + 
			"android.net.wifi," + 
			"android.nfc," + 
			"android.nfc.tech," + 
			"android.opengl," + 
			"android.os," + 
			"android.os.storage," + 
			"android.preference," + 
			"android.provider," + 
			"android.renderscript," + 
			"android.sax," + 
			"android.service.wallpaper," + 
			"android.speech," + 
			"android.speech.tts," + 
			"android.telephony," + 
			"android.telephony.cdma," + 
			"android.telephony.gsm," + 
			"android.test," + 
			"android.test.mock," + 
			"android.test.suitebuilder," + 
			"android.test.suitebuilder.annotation," + 
			"android.text," + 
			"android.text.format," + 
			"android.text.method," + 
			"android.text.style," + 
			"android.text.util," + 
			"android.util," + 
			"android.view," + 
			"android.view.accessibility," + 
			"android.view.animation," + 
			"android.view.inputmethod," + 
			"android.webkit," + 
			"android.widget," + 
			"com.android.internal.util," + 
			"dalvik.annotation," + 
			"dalvik.bytecode," + 
			"dalvik.system," + 
			"javax.crypto," + 
			"javax.crypto.interfaces," + 
			"javax.crypto.spec," + 
			"javax.microedition.khronos.egl," + 
			"javax.microedition.khronos.opengles," + 
			"javax.net," + 
			"javax.net.ssl," + 
			"javax.security.auth," + 
			"javax.security.auth.callback," + 
			"javax.security.auth.login," + 
			"javax.security.auth.x500," + 
			"javax.security.cert," + 
			"javax.sql," + 
			"javax.xml," + 
			"javax.xml.datatype," + 
			"javax.xml.namespace," + 
			"javax.xml.parsers," + 
			"javax.xml.transform," + 
			"javax.xml.transform.dom," + 
			"javax.xml.transform.sax," + 
			"javax.xml.transform.stream," + 
			"javax.xml.validation," + 
			"javax.xml.xpath," + 
			"javaxsql," + 
			"junit.framework," + 
			"junit.runner," + 
			"org.apache.commons.logging," + 
			"org.apache.http," + 
			"org.apache.http.auth," + 
			"org.apache.http.auth.params," + 
			"org.apache.http.client," + 
			"org.apache.http.client.entity," + 
			"org.apache.http.client.methods," + 
			"org.apache.http.client.params," + 
			"org.apache.http.client.protocol," + 
			"org.apache.http.client.utils," + 
			"org.apache.http.conn," + 
			"org.apache.http.conn.params," + 
			"org.apache.http.conn.routing," + 
			"org.apache.http.conn.scheme," + 
			"org.apache.http.conn.ssl," + 
			"org.apache.http.conn.util," + 
			"org.apache.http.cookie," + 
			"org.apache.http.cookie.params," + 
			"org.apache.http.entity," + 
			"org.apache.http.impl," + 
			"org.apache.http.impl.auth," + 
			"org.apache.http.impl.client," + 
			"org.apache.http.impl.conn," + 
			"org.apache.http.impl.conn.tsccm," + 
			"org.apache.http.impl.cookie," + 
			"org.apache.http.impl.entity," + 
			"org.apache.http.impl.io," + 
			"org.apache.http.io," + 
			"org.apache.http.message," + 
			"org.apache.http.params," + 
			"org.apache.http.protocol," + 
			"org.apache.http.util," + 
			"org.json," + 
			"org.w3c.dom," + 
			"org.w3c.dom.ls," + 
			"org.xml.sax," + 
			"org.xml.sax.ext," + 
			"org.xml.sax.helpers," + 
			"org.xmlpull.v1," + 
			"org.xmlpull.v1.sax2," + 
			"resources.arsc";
	
	private Felix m_felix;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        createFramework(
        		new net.luminis.jfall2012.clock.logger.Activator(),
        		new net.luminis.jfall2012.clock.provider.Activator());
        
        ClockTextField textField = (ClockTextField) findViewById(R.id.clockTextField1);
        DSTButton button = (DSTButton) findViewById(R.id.dSTButton1);
        textField.register(getDependencyManager(), this);
        button.register(getDependencyManager());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	private void createFramework(BundleActivator... activators) {
		try {
			Map<String, Object> config = new HashMap<String, Object>();
			File cache = new File("/data/data/" + getApplicationContext().getPackageName() + "/cache");
			recreate(cache);
			config.put(Constants.FRAMEWORK_STORAGE, cache.toString());
			config.put(Constants.FRAMEWORK_SYSTEMPACKAGES, SYSTEM_PACKAGES);
			// TODO describe: we need some additional properties here.
			config.put("org.osgi.framework.bundle.parent","framework");
			config.put("felix.service.urlhandlers", "false"); // We need this on Android 4, and it doesn't harm 3.1
			
			// We register our activators here
			config.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, Arrays.asList(activators));

			m_felix = new Felix(config);
			m_felix.start();
		} catch (BundleException e) {
			// Alert the proper authorities
		}
	}
	
	private void recreate(File dir) {
		delete(dir);
		dir.mkdirs();
		dir.mkdir();
	}

	private void delete(File f) {
		if (f.isDirectory()) {
			for (File child : f.listFiles()) {
				delete(child);
			}
		}
		f.delete();
	}

	private DependencyManager getDependencyManager() {
		return new DependencyManager(m_felix.getBundleContext());
	}
}
