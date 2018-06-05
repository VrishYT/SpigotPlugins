package com.vrish.grapple;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class Commands implements CommandExecutor {

    private Plugin plugin = main.getPlugin(main.class);

    public void grappleHelp(CommandSender sender) {

        if (sender instanceof Player) {

            sender.sendMessage("");
            sender.sendMessage("");
            sender.sendMessage("§e§lGrappling Hook Help");
            sender.sendMessage("§6§l-------------------");
            sender.sendMessage("");
            sender.sendMessage(" §b>§r §e/grapple §3- §2Opens the grappling hook GUI!");
            sender.sendMessage(" §b>§r §e/grapple help §3- §2Sends this help message!");
            sender.sendMessage(" §b>§r §e/grapple give <player> §3- §2Gives a player the grappling hook!");
            sender.sendMessage("");
            sender.sendMessage("§6§l-------------------");


        }else {

            sender.sendMessage("");
            sender.sendMessage("");
            sender.sendMessage("Grappling Hook Help");
            sender.sendMessage("-------------------");
            sender.sendMessage("");
            sender.sendMessage(" > /grapple - Opens the grappling hook GUI (Player only)!");
            sender.sendMessage(" > /grapple help - Sends this help message!");
            sender.sendMessage(" > /grapple give <player> - Gives a player the grappling hook!");
            sender.sendMessage("");
            sender.sendMessage("-------------------");

        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("grapple")) {

            if(args.length == 0) {

                if (sender instanceof Player) {
                    Inventories.mainGrappleInventory((Player) sender);
                }else {
                    grappleHelp(sender);
                }
                return true;
            }else if (args.length == 1) {

                if (args[0].equalsIgnoreCase("help")) {
                    grappleHelp(sender);
                }else if (args[0].equalsIgnoreCase("give")) {

                    sender.sendMessage(ChatColor.RED + "Please specify which player! Do /grapple help for help!");

                }else {
                    grappleHelp(sender);
                }
                return true;
            }else if (args.length == 2) {

                if (args[0].equalsIgnoreCase("give")) {

                    Player target = plugin.getServer().getPlayer(args[1]);
                    if (!(null == target)) {

                        target.getInventory().addItem(Recipe.getGrappleHook());
                        sender.sendMessage(ChatColor.GREEN + "Given Grappling Hook to Player: " + target.getName());

                    }else sender.sendMessage(ChatColor.RED + "Player not found.");

                }
                return true;
            }

        }

        return false;
    }

}
