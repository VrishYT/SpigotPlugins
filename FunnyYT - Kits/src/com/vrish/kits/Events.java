package com.vrish.kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class Events implements Listener {

	private Plugin plugin = main.getPlugin(main.class);
	
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
	
}
