package com.vrish.grapple;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

import static com.vrish.grapple.Recipe.grappleRecipe;

public class main extends JavaPlugin implements Listener {

    public ConsoleCommandSender consoleSender = getServer().getConsoleSender();


    @Override
    public void onEnable() {

        consoleSender.sendMessage(ChatColor.DARK_GREEN + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
        consoleSender.sendMessage(ChatColor.GREEN      + " [Grappling Hooks] has been enabled  ");
        consoleSender.sendMessage(ChatColor.DARK_GREEN + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
        getCommand("grapple").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Events(), this);
        grappleRecipe();

    }

    @Override
    public void onDisable() {

        consoleSender.sendMessage(ChatColor.DARK_RED + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
        consoleSender.sendMessage(ChatColor.RED      + " [Grappling Hooks] has been disabled ");
        consoleSender.sendMessage(ChatColor.DARK_RED + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
        saveConfig();

    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                consoleSender.sendMessage("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                consoleSender.sendMessage("Config.yml found, loading!");
            }
        } catch (Exception e) {
            Logger.logToFile(e.getMessage());

        }

    }

}
