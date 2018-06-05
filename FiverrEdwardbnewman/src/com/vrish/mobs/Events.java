package com.vrish.mobs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;


public class Events implements Listener {

	private Plugin plugin = getPlugin(Main.class);
	
	@EventHandler
	public void enderTeleport(EntityTeleportEvent tp) {
		
		EntityType tpEntityType = tp.getEntityType();
		int tpDistance = plugin.getConfig().getInt("MobBehaviour.Enderman.tp-distance");
		
		if (tpEntityType == EntityType.ENDERMAN) {
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				  if (player.getLocation().distance(tp.getFrom()) <= tpDistance) {
				    
					 Location to = tp.getTo();
					 if (to.getWorld() == player.getWorld()) {
						 
						 while(!to.getBlock().getType().isTransparent()) {
							 
							 to.setY(to.getBlockY() + 1);
							 
						 }
						 player.teleport(to);
						 player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 40, 1, false, false));
						 
						 
					 }
					  
				  }
			}
			
		}
		
	}
	
	@EventHandler
	public void onCreeperExplode(EntityExplodeEvent explode) {
		
		if (explode.getEntityType() == EntityType.CREEPER) {
			
			int nauseaDistance = plugin.getConfig().getInt("MobBehaviour.Creeper.nausea-distance");
			Boolean creeperGriefing = (plugin.getConfig().getInt("MobBehaviour.Creeper.creeper-griefing")) == 0;
			explode.setCancelled(creeperGriefing);
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				  if (player.getLocation().distance(explode.getLocation()) <= nauseaDistance) {
				    
					  PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION, 600, 1);
					  player.addPotionEffect(nausea);
				  }
			}
			
		}
		
	}

}