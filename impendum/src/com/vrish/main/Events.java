package com.vrish.main;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Events implements Listener {

	private static Plugin plugin = main.getPlugin(main.class);
	private static FileConfiguration config = plugin.getConfig();
	
	@EventHandler
	public void onClick(PlayerInteractEvent click) {
		
		Player clicker = click.getPlayer();
		Action action = click.getAction();
		
		if (action == Action.RIGHT_CLICK_AIR) {
			

			
		}else if (action == Action.RIGHT_CLICK_BLOCK) { 
			
			
			
		}else if (action == Action.LEFT_CLICK_AIR) {
			
			
			
		}else if (action == Action.LEFT_CLICK_BLOCK) {
			
			
			
		}
		
	}

	@EventHandler
	public void eat(PlayerItemConsumeEvent eat ) {

		Player player = eat.getPlayer();
		ItemStack item = eat.getItem();
		Material type = item.getType();

		if (type.equals(Material.MUSHROOM_SOUP)) {

			eat.setCancelled(true);
			item.setAmount(item.getAmount() - 1);

			int healby = config.getInt("Soup.heal-by");
			player.setHealth(player.getHealth() + healby);

		}

	}
	
}
