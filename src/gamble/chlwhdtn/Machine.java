package gamble.chlwhdtn;

import org.bukkit.Location;

public class Machine {
	
	public Location B1, B2, B3;
	public Location StartB;
	public Machine(Location startB, Location b1, Location b2, Location b3) {
		StartB = startB;
		B1 = b1;
		B2 = b2;
		B3 = b3;
	}
	public boolean isRunning = false;
	
}
