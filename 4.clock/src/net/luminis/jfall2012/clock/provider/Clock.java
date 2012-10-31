package net.luminis.jfall2012.clock.provider;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import net.luminis.jfall2012.clock.ClockControl;
import net.luminis.jfall2012.clock.ClockListener;

public class Clock implements ClockControl {
	private final List<ClockListener> m_listeners = new CopyOnWriteArrayList<ClockListener>();
	
	private Timer m_timer = new Timer();
	private TimerTask m_clock;

	private boolean m_dst;
	
	@Override
	public void setDST(boolean dst) {
		m_dst = dst;
	}
	
	public synchronized void start() {
		m_clock = new ClockTask();
		m_timer.schedule(m_clock, 0, 1000);
	}
	
	public synchronized void stop() {
		m_clock.cancel();
	}
	
	private class ClockTask extends TimerTask {
		@Override
		public void run() {
			Date now = new Date();
			boolean inDST = TimeZone.getDefault().inDaylightTime(now);
			if (inDST && !m_dst) {
				// subtract one hour
				now = new Date(now.getTime() - 3600000);
			}
			else if (!inDST && m_dst) {
				// add one hour
				now = new Date(now.getTime() + 3600000);
			}
			System.out.println("TICK, dude!");
			for (ClockListener listener : m_listeners) {
				listener.tick(now.toString());
			}
		}
	}
	
	public void listenerAdded(ClockListener listener) {
		System.out.println("New listener!");
		m_listeners.add(listener);
	}
	
	public void listenerRemoved(ClockListener listener) {
		m_listeners.remove(listener);
	}

}
