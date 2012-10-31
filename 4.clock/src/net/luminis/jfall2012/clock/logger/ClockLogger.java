package net.luminis.jfall2012.clock.logger;

import net.luminis.jfall2012.clock.ClockListener;

public class ClockLogger implements ClockListener {
	@Override
	public void tick(String time) {
		System.out.println("[ClockLogger] Current time: " + time);
	}
}
