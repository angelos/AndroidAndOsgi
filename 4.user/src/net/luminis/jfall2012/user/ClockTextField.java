package net.luminis.jfall2012.user;

import net.luminis.jfall2012.clock.ClockListener;

import org.apache.felix.dm.DependencyManager;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ClockTextField extends TextView implements ClockListener {
	private Activity m_activity;

	public ClockTextField(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void register(DependencyManager manager, Activity activity) {
		m_activity = activity;

		manager.add(manager.createComponent()
				.setInterface(ClockListener.class.getName(), null)
				.setImplementation(this));
	}

	@Override
	public void tick(final String time) {
		m_activity.runOnUiThread(new Runnable() {
			public void run() {
				setText(time);
			}
		});
	}
}

