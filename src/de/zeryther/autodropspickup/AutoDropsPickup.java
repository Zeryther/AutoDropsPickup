package de.zeryther.autodropspickup;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import de.zeryther.autodropspickup.cmd.MainExecutor;
import de.zeryther.autodropspickup.listener.MainListener;

public class AutoDropsPickup extends JavaPlugin {

	private static AutoDropsPickup instance;
	
	@Override
	public void onEnable(){
		instance = this;
		saveDefaultConfig();
		
		registerListeners();
		registerCommands();
		initConfig();
	}
	
	public static AutoDropsPickup getInstance(){
		return instance;
	}
	
	private void registerListeners(){
		Bukkit.getPluginManager().registerEvents(new MainListener(), this);
	}
	
	private void registerCommands(){
		getCommand("autodropspickup").setExecutor(new MainExecutor());
	}
	
	public static void log(String msg, boolean isError){
		if(isError){
			Bukkit.getConsoleSender().sendMessage(Util.MESSAGE_PREFIX + "§c" + msg);
		} else {
			Bukkit.getConsoleSender().sendMessage(Util.MESSAGE_PREFIX + "§a" + msg);
		}
	}
	
	public void initConfig(){
		Util.MESSAGE_PREFIX = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.prefix"));
		Util.MESSAGE_INVENTORYFULL = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.notEnoughSpaceInInventory"));
		
		Util.DEFAULT_PICKUPMOBDROPS = getConfig().getBoolean("settings.defaults.pickupMobDrops");
		Util.DEFAULT_PICKUPPLAYERDROPS = getConfig().getBoolean("settings.defaults.pickupPlayerDrops");
		
		log("Loaded config.", false);
	}
	
}