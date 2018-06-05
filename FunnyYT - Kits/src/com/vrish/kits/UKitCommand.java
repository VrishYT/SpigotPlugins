package com.vrish.kits;

import org.bukkit.ChatColor;
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
			player.sendMessage("test player");
			
			return true;
			
		}else{
			
			sender.sendMessage(ChatColor.RED + "test server");
			
			return true;
			
		}
	}

}
