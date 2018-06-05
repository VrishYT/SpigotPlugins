package com.vrish.mobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

import static com.vrish.mobs.MobSpawner.spawnSlime;

public class Main extends JavaPlugin implements Listener {

    public ConsoleCommandSender consoleSender = this.getServer().getConsoleSender();

	private int spawnRate = this.getConfig().getInt("MobBehaviour.Slimes.spawn-rate");

public void onEnable() {

    	consoleSender.sendMessage(ChatColor.DARK_GREEN + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
    	consoleSender.sendMessage(ChatColor.GREEN      + "[Mob Behaviour] has been enabled ");
		consoleSender.sendMessage(ChatColor.DARK_GREEN + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
		getServer().getPluginManager().registerEvents(new Events(), this);
        loadConfig();
		Logger.logToFile("");
		Logger.logToFile("");
		Logger.logToFile("");
		Logger.logToFile("         SERVER STARTED");
		Logger.logToFile("");
		Logger.logToFile("");
		Logger.logToFile("");


         new BukkitRunnable(){

            @Override
            public void run() {
            		for (Player player : Bukkit.getOnlinePlayers()) {

            			spawnSlime(player);

					}
            }

        }.runTaskTimer(this, 0 , spawnRate);

}

    @Override
    public void onDisable() {

		consoleSender.sendMessage(ChatColor.DARK_RED + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
    	consoleSender.sendMessage(ChatColor.RED      + "[Mob Behaviour] has been disabled");
		consoleSender.sendMessage(ChatColor.DARK_RED + "*-+-*-+-*-+-*-+-*-+-*-+-*-+-*-+-*");
    	this.saveConfig();
    	
    }

	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	private void createConfig() {
		try {
			if (!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}
			File file = new File(getDataFolder(), "config.yml");
			if (!file.exists()) {
				getLogger().info("Config.yml not found, creating!");
				saveDefaultConfig();
			} else {
				getLogger().info("Config.yml found, loading!");
			}
		} catch (Exception e) {
			Logger.logToFile(e.getMessage());

		}

	}


}
