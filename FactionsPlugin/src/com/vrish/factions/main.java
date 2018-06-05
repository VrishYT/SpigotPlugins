package com.vrish.factions;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

import static com.vrish.factions.Logger.*;

public class main extends JavaPlugin {

    public ConsoleCommandSender consoleSender = getServer().getConsoleSender();
    public static PlayerConfig pcfg;
    public static FactionConfig fcfg;

    @Override
    public void onEnable() {

        consoleSender.sendMessage(ChatColor.DARK_GREEN + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
        consoleSender.sendMessage(ChatColor.GREEN      + " [Factions] has been enabled  ");
        consoleSender.sendMessage(ChatColor.DARK_GREEN + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
        getCommand("f").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Events(), this);
        createConfig();
        loadPlayerConfig();
        loadFactionConfig();

    }

    @Override
    public void onDisable() {

        consoleSender.sendMessage(ChatColor.DARK_RED + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
        consoleSender.sendMessage(ChatColor.RED      + " [Factions] has been disabled ");
        consoleSender.sendMessage(ChatColor.DARK_RED + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
        saveConfig();

    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File config = new File(getDataFolder(), "config.yml");
            if (!config.exists()) {
                consoleSender.sendMessage("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                consoleSender.sendMessage("Config.yml found, loading!");
            }
        } catch (Exception e) {
            logToFile(e.getMessage());

        }

    }

    public void loadPlayerConfig(){
        pcfg = new PlayerConfig();
        pcfg.setup();
        pcfg.savePlayers();
        pcfg.reloadPlayers();
    }
    public void loadFactionConfig(){
        fcfg = new FactionConfig();
        fcfg.setup();
        fcfg.saveConfig();
        fcfg.reloadConfig();

    }
}
