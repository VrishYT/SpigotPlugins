package com.vrish.grapple;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class GrapplePull {

    private static main plugin = main.getPlugin(main.class);

    public static void grapplePull(Player p, Location l) {

        final Vector v = getVectorForPoints(p.getLocation().add(0,0.5,0), l.add(0,3,0));
        p.setVelocity(v);

    }

    private static Vector getVectorForPoints(Location l1, Location l2) {
        double g = -0.08;
        double d = l2.distance(l1);
        double t = d/1.3;
        double vX = ((1.0+0.07*d)) * (l2.getX() - l1.getX())/t;
        double vY = ((1.0+0.03*d) * (l2.getY() - l1.getY())/t - 0.5*g*(d*1.1));
        double vZ = ((1.0+0.07*d)) * (l2.getZ() - l1.getZ())/t;
        return new Vector(vX, vY, vZ);
    }

}
