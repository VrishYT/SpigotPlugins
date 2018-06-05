package com.vrish.factions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class PlayerConfig {

    private Plugin plugin = main.getPlugin(main.class);

    public FileConfiguration playercfg;
    public File playerfile;

    public void setup() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        playerfile = new File(plugin.getDataFolder(), "players.yml");

        if (!playerfile.exists()) {
            try {
                playerfile.createNewFile();
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The players.yml file has been created");
            } catch (IOException e) {
                plugin.getServer().getConsoleSender()
                        .sendMessage(ChatColor.RED + "Could not create the players.yml file");
            }
        }

        playercfg = YamlConfiguration.loadConfiguration(playerfile);
    }

    public FileConfiguration getPlayers() {
        return playercfg;
    }

    public void savePlayers() {
        try {
            playercfg.save(playerfile);
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "The players.yml file has been saved");

        } catch (IOException e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the players.yml file");
        }
    }

    public void reloadPlayers() {
        playercfg = YamlConfiguration.loadConfiguration(playerfile);
        plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "The players.yml file has been reload");

    }
}
