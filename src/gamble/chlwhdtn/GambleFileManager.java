package gamble.chlwhdtn;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import economy.chlwhdtn.Economy;

public class GambleFileManager {

	private static FileConfiguration GambleConfig = null;
	private static File GambleConfigFile = null;

	public static void reloadConfig() {
		if (GambleConfigFile == null) {
			GambleConfigFile = new File(Economy.getInstance().getDataFolder(), "Gamble.yml");
		}
		GambleConfig = YamlConfiguration.loadConfiguration(GambleConfigFile);
		if(!GambleConfig.contains("Gamble")) return;
		for (String name : GambleConfig.getConfigurationSection("Gamble").getKeys(false)) {
			Location btn, B1, B2, B3;
			btn = new Location(Bukkit.getWorld("land"), GambleConfig.getInt("Gamble." + name + ".xs"), GambleConfig.getInt("Gamble." + name + ".ys"), GambleConfig.getInt("Gamble." + name + ".zs"));
			B1 = new Location(Bukkit.getWorld("land"), GambleConfig.getInt("Gamble." + name + ".x1"), GambleConfig.getInt("Gamble." + name + ".y1"), GambleConfig.getInt("Gamble." + name + ".z1"));
			B2 = new Location(Bukkit.getWorld("land"), GambleConfig.getInt("Gamble." + name + ".x2"), GambleConfig.getInt("Gamble." + name + ".y2"), GambleConfig.getInt("Gamble." + name + ".z2"));
			B3 = new Location(Bukkit.getWorld("land"), GambleConfig.getInt("Gamble." + name + ".x3"), GambleConfig.getInt("Gamble." + name + ".y3"), GambleConfig.getInt("Gamble." + name + ".z3"));
			
			MachineManager.LoadMachine(name, new Machine(btn, B1, B2, B3));
		}
	}

	public static FileConfiguration getConfig() {
		if (GambleConfig == null) {
			reloadConfig();
		}
		return GambleConfig;
	}

	public static void saveConfig() {
		if (GambleConfig == null || GambleConfigFile == null) {
			return;
		}
		try {
			for (String name : MachineManager.getMachineMap().keySet()) {
				GambleConfig.set("Gamble." + name + ".xs", MachineManager.getMachineMap().get(name).StartB.getBlockX());
				GambleConfig.set("Gamble." + name + ".ys", MachineManager.getMachineMap().get(name).StartB.getBlockY());
				GambleConfig.set("Gamble." + name + ".zs", MachineManager.getMachineMap().get(name).StartB.getBlockZ());
				
				GambleConfig.set("Gamble." + name + ".x1", MachineManager.getMachineMap().get(name).B1.getBlockX());
				GambleConfig.set("Gamble." + name + ".y1", MachineManager.getMachineMap().get(name).B1.getBlockY());
				GambleConfig.set("Gamble." + name + ".z1", MachineManager.getMachineMap().get(name).B1.getBlockZ());
				
				GambleConfig.set("Gamble." + name + ".x2", MachineManager.getMachineMap().get(name).B2.getBlockX());
				GambleConfig.set("Gamble." + name + ".y2", MachineManager.getMachineMap().get(name).B2.getBlockY());
				GambleConfig.set("Gamble." + name + ".z2", MachineManager.getMachineMap().get(name).B2.getBlockZ());
				
				GambleConfig.set("Gamble." + name + ".x3", MachineManager.getMachineMap().get(name).B3.getBlockX());
				GambleConfig.set("Gamble." + name + ".y3", MachineManager.getMachineMap().get(name).B3.getBlockY());
				GambleConfig.set("Gamble." + name + ".z3", MachineManager.getMachineMap().get(name).B3.getBlockZ());
			}
			getConfig().save(GambleConfigFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
