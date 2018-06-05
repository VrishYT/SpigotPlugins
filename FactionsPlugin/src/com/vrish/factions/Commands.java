package com.vrish.factions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("f")) {

            if (args.length == 0) {

                sender.sendMessage(ChatColor.YELLOW + "______         _   _                 ");
                sender.sendMessage(ChatColor.YELLOW + "|  ___|       | | (_)                ");
                sender.sendMessage(ChatColor.YELLOW + "| |_ __ _  ___| |_ _  ___  _ __  ___ ");
                sender.sendMessage(ChatColor.YELLOW + "|  _/ _` |/ __| __| |/ _ || '_ |/ __|");
                sender.sendMessage(ChatColor.YELLOW + "| | | (_ || (_| |_| | (_) | | | |__ |");
                sender.sendMessage(ChatColor.YELLOW + "|_| |__,_||___||__|_||___/|_| |_|___/");
                sender.sendMessage("");
                sender.sendMessage(ChatColor.GOLD + "Use /f help to see a full list of commands!");
            }

            if (args[0].equalsIgnoreCase("create")) {

                if (args.length == 1) {

                }

            }

            return true;
        }
        return false;
    }
}
