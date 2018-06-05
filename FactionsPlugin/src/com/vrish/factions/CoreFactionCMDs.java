package com.vrish.factions;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import static com.vrish.factions.HashMaps.*;

public class CoreFactionCMDs {

    private Plugin plugin = main.getPlugin(main.class);
    FileConfiguration fcfg = main.fcfg.getConfig();

    public void createFaction(Player owner, String name) {

        int id = 0;
        for (id = 0; id > -1 ; id++) {

            if (HashMaps.playerFactionID.containsValue(id)) {
                continue;
            }else break;

        }
        HashMaps.playerFactionID.put(owner.getUniqueId(), id);
        nameFactionID.put(name, id);
        fcfg.addDefault("Faction."+id+".name",name);
        joinFaction(owner, name);
    }
    public void joinFaction(Player player, String name) {

        if (nameFactionID.containsKey(name.toLowerCase())) {

            playerFactionID.put(player.getUniqueId(), nameFactionID.get(name));

        }

    }
    public void inviteFaction(Player player, String name, Boolean yesNoBool) {



    }
    public void leaveFaction(Player player) {



    }
    public void kickPlayerFaction(Player player) {



    }
    public void disbandFaction(String name) {



    }
}
