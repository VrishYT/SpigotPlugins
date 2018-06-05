package com.vrish.factions;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HashMaps {

    public static HashMap<String, Integer> nameFactionID; //K = FacID; V = FactionName
    public static HashMap<UUID, Integer> playerFactionID; //K = PlayerID; V = FactionID
    public static HashMap<UUID, List<Integer>> playerFactionInvites; //K = PlayerID; V = List of Invites using FactionID
    public static HashMap<UUID, Integer> playerTimePlayed; //K = PlayerID; V = Time Played in seconds
    public static HashMap<UUID, Boolean> playerInFaction;

}
