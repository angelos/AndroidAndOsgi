package net.luminis.jfall2012.clock.threadbased;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import net.luminis.jfall2012.clock.provider.ClockListener;

public class ClockThread {
	private final List<ClockListener> m_listeners = new CopyOnWriteArrayList<ClockListener>();
	
	private Timer m_timer = new Timer();
	private TimerTask m_clock;
	
	public synchronized void start() {
		m_clock = new Clock();
		m_timer.schedule(m_clock, 0, 1000);
	}
	
	public synchronized void stop() {
		m_clock.cancel();
	}
	
	private class Clock extends TimerTask {
		@Override
		public void run() {
			String time = new Date().toString();
			for (ClockListener listener : m_listeners) {
				listener.tick(time);
			}
		}
	}
	
	public void listenerAdded(ClockListener listener) {
		m_listeners.add(listener);
	}
	
	public void listenerRemoved(ClockListener listener) {
		m_listeners.remove(listener);
	}
}
