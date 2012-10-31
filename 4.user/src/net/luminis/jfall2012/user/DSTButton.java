package net.luminis.jfall2012.user;

import net.luminis.jfall2012.clock.ClockControl;

import org.apache.felix.dm.DependencyManager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class DSTButton extends Button {
	private boolean m_started;
	
	private volatile ClockControl m_clockControl;
	private boolean m_dst;

	public DSTButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setText("Toggle DST");
	}
	
	public void start() {
		m_started = true;
	}

	public void register(DependencyManager manager) {
		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!m_started) {
					return;
				}
				m_dst = !m_dst;
				m_clockControl.setDST(m_dst);
			}
		});
		
		manager.add(manager.createComponent()
				.setImplementation(this)
				.add(manager.createServiceDependency()
						.setService(ClockControl.class)
						.setRequired(true)));
	}

}
