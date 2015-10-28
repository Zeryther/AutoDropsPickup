package de.zeryther.autodropspickup.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import de.zeryther.autodropspickup.Util;

public class MainListener implements Listener {

	public MainListener(){}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		if(Util.DEFAULT_PICKUPPLAYERDROPS){
			Player p = e.getEntity();
			
			if(p.getKiller() != null && p.getKiller() != p){
				if(Util.getEmptySlotsInInventory(p.getKiller()) >= e.getDrops().size()){
					for(ItemStack i : e.getDrops()){
						p.getKiller().getInventory().addItem(i);
					}
					
					e.getDrops().clear();
				} else {
					p.sendMessage(Util.MESSAGE_PREFIX + Util.MESSAGE_INVENTORYFULL);
				}
			}
		}
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e){
		if(Util.DEFAULT_PICKUPMOBDROPS){
			if(e.getEntity().getType() != EntityType.PLAYER && e.getEntity().getKiller() != null){
				Player p = e.getEntity().getKiller();
				
				if(Util.getEmptySlotsInInventory(p.getKiller()) >= e.getDrops().size()){
					for(ItemStack i : e.getDrops()){
						p.getKiller().getInventory().addItem(i);
					}
					
					e.getDrops().clear();
				} else {
					p.sendMessage(Util.MESSAGE_PREFIX + Util.MESSAGE_INVENTORYFULL);
				}
			}
		}
	}
	
}
