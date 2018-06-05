package com.vrish.factions;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class FactionConfig {
    private Plugin plugin = main.getPlugin(main.class);

    public FileConfiguration factioncfg;
    public File factionfile;

    public void setup() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        factionfile = new File(plugin.getDataFolder(), "Factions.yml");

        if (!factionfile.exists()) {
            try {
                factionfile.createNewFile();
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The Factions.yml file has been created");
            } catch (IOException e) {
                plugin.getServer().getConsoleSender()
                        .sendMessage(ChatColor.RED + "Could not create the Factions.yml file");
            }
        }

        factioncfg = YamlConfiguration.loadConfiguration(factionfile);
    }

    public FileConfiguration getConfig() {
        return factioncfg;
    }

    public void saveConfig() {
        try {
            factioncfg.save(factionfile);
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "The Factions.yml file has been saved");

        } catch (IOException e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the Factions.yml file");
        }
    }

    public void reloadConfig() {
        factioncfg = YamlConfiguration.loadConfiguration(factionfile);
        plugin.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "The Factions.yml file has been reload");

    }
}

