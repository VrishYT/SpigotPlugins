package com.vrish.kitsplus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.minecraft.server.v1_12_R1.CommandExecute;

public class UKitCommand extends CommandExecute implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			
			Player player = (Player) sender;
			if (player.isOp() || player.hasPermission("kitsplus.admin")) {
				
				if (args.length == 0) {
					
					Inventories i = new Inventories();
					i.ukitInv(player);
					
				}
				
			}else {
				
				player.sendMessage("�cYou do not have permission.");
				
			}
			
			return true;
			
		}else{
			
			
			
			return true;
			
		}
	}

}
