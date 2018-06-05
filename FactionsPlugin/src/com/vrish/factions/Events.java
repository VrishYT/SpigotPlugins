package com.vrish.factions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

    }

}
