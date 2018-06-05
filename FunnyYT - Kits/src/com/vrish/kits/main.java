package com.vrish.kits;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import com.vrish.kits.Commands;
import com.vrish.kits.Events;

public class main extends JavaPlugin implements Listener{

    public void onEnable() {

    	this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "*+-+*+-+*+-+*+-+*+-+*+-+*+-+*");
    	this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Kits +] has been enabled.");
    	this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "*+-+*+-+*+-+*+-+*+-+*+-+*+-+*");
		getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("kit").setExecutor(new KitCommand());
        getCommand("ukit").setExecutor(new UKitCommand());
        loadConfig();
        
        
    }

    @Override
    public void onDisable() {

    	this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED+ "*+-+*+-+*+-+*+-+*+-+*+-+*+-+*");
    	this.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Kits +] has been disabled.");
    	this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED+ "*+-+*+-+*+-+*+-+*+-+*+-+*+-+*");
    	this.saveConfig();
    	
    }
    
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
