package com.vrish.kits;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class Inventories implements Listener {

	private Plugin plugin = main.getPlugin(main.class);
	
	public void kitInv(Player player) {
		
		Inventory i = plugin.getServer().createInventory(null, 27, ChatColor.GOLD + "Kits");
		
		
		
		player.openInventory(kits);
		
	}
	
}
