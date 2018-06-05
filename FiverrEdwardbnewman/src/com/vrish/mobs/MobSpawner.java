package com.vrish.mobs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import static com.vrish.mobs.Logger.logToFile;
import static com.vrish.random.randomInt.*;
import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class MobSpawner implements Listener {

	private static Plugin plugin = getPlugin(Main.class);

	static ConsoleCommandSender console = plugin.getServer().getConsoleSender();

	private static FileConfiguration config = plugin.getConfig();

	private static int kingSize = plugin.getConfig().getInt("MobBehaviour.Slimes.king-slime-size");
	private static int kingChance = plugin.getConfig().getInt("MobBehaviour.Slimes.king-slime-chance");
    private static int spawnRange = plugin.getConfig().getInt("MobBehaviour.Slimes.spawn-range");


    public static void spawnSlime(Player player) {

        Location loc = player.getLocation();
        loc = randomLocation(loc);

        int chance = randInt(1,100);

        World world = loc.getWorld();

        if (chance <= kingChance ) {
            spawnGiantSlime(world, loc);
        }
        else spawnSmallSlime(world, loc);

	}
//
    public static void spawnSmallSlime(World world, Location loc) {

        Slime slime = (Slime) world.spawnEntity(loc, EntityType.SLIME);
        slime.setSize(2);

        logToFile("[Slimes] Slime spawned at (" +
                loc.getBlockX() + ", " +
                loc.getBlockY() + ", " +
                loc.getBlockZ() + ") in World: " +
                loc.getWorld().getName());

    }

    public static void spawnGiantSlime(World world, Location loc) {

        Slime slime = (Slime) world.spawnEntity(loc, EntityType.SLIME);
        slime.setSize(kingSize);

        logToFile("[Slimes] King Slime spawned at (" +
                loc.getBlockX() + ", " +
                loc.getBlockY() + ", " +
                loc.getBlockZ() + ") in World: " +
                loc.getWorld().getName());
        System.out.println("King Slime spawned at (" +
                loc.getBlockX() + ", " +
                loc.getBlockY() + ", " +
                loc.getBlockZ() + ") in World: " +
                loc.getWorld().getName());


    }

    private static Location randomLocation(Location loc) {

        int x = loc.getBlockX();
        int z = loc.getBlockZ();

        x = x + randInt(1,spawnRange);
        z = z + randInt(1,spawnRange);

        loc.setX(x);
        loc.setZ(z);

        while (!loc.getBlock().getType().isTransparent()) {

            loc.setY(loc.getBlockY() + 1);

        }

      return loc;
    }


}
