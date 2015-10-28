package de.zeryther.autodropspickup.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zeryther.autodropspickup.AutoDropsPickup;
import de.zeryther.autodropspickup.Util;

public class MainExecutor implements CommandExecutor {

	public MainExecutor(){}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("autodropspickup")){
			if(sender instanceof Player){
				Player p = (Player)sender;
				
				if(args.length == 0){
					p.sendMessage("§cThis server is using §eAutoDropsPickup §cversion §e" + 1.0);
					p.sendMessage("§eAutoDropsPickup §cwas made by §eZeryther§c.");
					p.sendMessage("§cMore information at §ehttp://www.zeryther.de");
				} else {
					if(args[0].equalsIgnoreCase("reload")){
						if(p.hasPermission("adp.reload")){
							AutoDropsPickup.getInstance().reloadConfig();
							AutoDropsPickup.getInstance().initConfig();
							p.sendMessage(Util.MESSAGE_PREFIX + "§aDone. Please check the console, there may be errors.");
						} else {
							p.sendMessage(Util.MESSAGE_PREFIX + "§cYou do not have permission to execute this command.");
						}
					} else {
						p.sendMessage(Util.MESSAGE_PREFIX + "§c/" + label + " <reload>");
					}
				}
			} else {
				AutoDropsPickup.log("Please execute this command as a player.", true);
			}
		}
		
		return false;
	}
	
}
