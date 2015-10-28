package de.zeryther.autodropspickup;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Util {

	public static String MESSAGE_PREFIX;
	public static String MESSAGE_INVENTORYFULL;
	
	public static boolean DEFAULT_PICKUPMOBDROPS;
	public static boolean DEFAULT_PICKUPPLAYERDROPS;
	
	public static boolean PLUGINHOOK_WORLDGUARD;
	
	public static int getEmptySlotsInInventory(Player p){
		int count = 0;
		for (ItemStack i : p.getInventory()) {
			if (i == null) {
				count++;
			}
		}
		
		return count;
	}
	
}
