package com.vrish.main;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PvPToggleCommand implements CommandExecutor, Listener {

    public void pvpHelp(CommandSender sender) {

        if (sender instanceof Player) {



        }else {



        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("pvp")) {

            if (args.length == 1) {
                if (sender instanceof Player) {

                    if (args[0].equalsIgnoreCase("on")) {

                        Player player = (Player) sender;
                        Chunk chunk = player.getLocation().getChunk();

                    } else if (args[0].equalsIgnoreCase("off")) {


                    } else pvpHelp(sender);
                }else sender.sendMessage(ChatColor.RED + "Only players can use this command!");

            }else pvpHelp(sender);

            return true;
        }

        return false;
    }
}
