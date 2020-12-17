package gamble.chlwhdtn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import economy.chlwhdtn.Economy;
import net.md_5.bungee.api.ChatColor;

public class Gamble extends JavaPlugin implements CommandExecutor {
	
	@Override
	public void onEnable() {
		Economy.online(this);
		GambleFileManager.reloadConfig();
		getCommand("gamble").setExecutor(this);
	}
	
	@Override
	public void onDisable() {
		GambleFileManager.saveConfig();
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.isOp() == false)
			return false;
		
		if(args.length == 12) {
			// /gamble sx sy sz x1 y1 z1 x2 y2 z2 x3 y3 z3
			int[] ar = new int[12];
			for(int i = 0; i < 12; i++) {
				ar[i] = Integer.parseInt(args[i]);
			}
			int c = 0;
			MachineManager.addMachine(
					new Location(Bukkit.getWorld("land"), ar[c++], ar[c++], ar[c++]), 
					new Location(Bukkit.getWorld("land"), ar[c++], ar[c++], ar[c++]), 
					new Location(Bukkit.getWorld("land"), ar[c++], ar[c++], ar[c++]), 
					new Location(Bukkit.getWorld("land"), ar[c++], ar[c++], ar[c])
					);
			saveConfig();
			return true;
		} else {
			sender.sendMessage(ChatColor.RED + "/gamble <트리거X> <트리거Y> <트리커Z> <슬롯1_X> <슬롯1_Y> <슬롯1_Z> <슬롯2_X> <슬롯2_Y> <슬롯2_Z> <슬롯3_X> <슬롯3_Y> <슬롯3_Z>");
		}
		return false;
	}
	
	

}
