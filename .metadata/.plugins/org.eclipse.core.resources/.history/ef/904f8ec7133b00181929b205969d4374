package com.vrish.kits;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.minecraft.server.v1_12_R1.CommandExecute;

public class KitCommand extends CommandExecute implements Listener,CommandExecutor {

	public static String cmd1 = "kit";
	public static String cmd2 = "ukit";	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				Inventories i = new Inventories();
				i.kitInv(player);
				
				return true;
				
			}else{
				
				sender.sendMessage(ChatColor.RED + "This command can only be used by a player.");
				sender.sendMessage(ChatColor.RED + "Please use /ukit instead.");
				
				return true;
				
			}
	}

}
