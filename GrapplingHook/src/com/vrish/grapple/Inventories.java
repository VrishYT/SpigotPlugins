package com.vrish.grapple;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Inventories implements Listener {

    private static Plugin plugin = main.getPlugin(main.class);

    public static void fillPanes (Inventory inv){
        for (int i = 0 ; i < inv.getSize() ; i++){

            if (inv.getItem(i) == null){
                ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE , 1, (byte)15);
                ItemMeta meta = stack.getItemMeta();
                meta.setDisplayName(" ");
                stack.setItemMeta(meta);
                inv.setItem(i, stack);

            }
            if (inv.getItem(i).getType().equals(Material.AIR)){
                ItemStack stack = new ItemStack(Material.STAINED_GLASS_PANE , 1, (byte)15);
                ItemMeta meta = stack.getItemMeta();
                meta.setDisplayName(" ");
                stack.setItemMeta(meta);
                inv.setItem(i, stack);
            }


        }

    }


    public static void mainGrappleInventory(Player player) {

        Inventory i = plugin.getServer().createInventory(null, 27, "§eGrappling Hook");

        ItemStack grapple = Recipe.getGrappleHook();

        i.setItem(13, grapple);

        fillPanes(i);

        player.openInventory(i);

    }

}
