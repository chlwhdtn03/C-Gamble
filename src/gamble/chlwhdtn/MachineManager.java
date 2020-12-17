package gamble.chlwhdtn;

import java.util.HashMap;

import org.bukkit.Location;


public class MachineManager {

	private static HashMap<String, Machine> hashmap = new HashMap<String, Machine>();
	
	public static Machine addMachine(Location btn, Location B1, Location B2, Location B3) {
		Machine data =  new Machine(btn, B1, B2, B3);
		hashmap.put("Machine-" + (hashmap.size()+1), data);
		return data;
	}
	
	public static Machine getMachine(String string) {
		return hashmap.get(string);
	}
	
	public static void LoadMachine(String key, Machine data) {
		hashmap.put(key, data);
	}
	
	public static Machine getMachineButton(Location loc) {
		for(Machine data : hashmap.values()) {
			if(loc.getBlockX() != data.StartB.getBlockX())
				continue;
			if(loc.getBlockY() != data.StartB.getBlockY())
				continue;
			if(loc.getBlockZ() != data.StartB.getBlockZ())
				continue;
			return data;
		}
		return null;
	}

	public static HashMap<String, Machine> getMachineMap() {
		return hashmap;
	}
}
