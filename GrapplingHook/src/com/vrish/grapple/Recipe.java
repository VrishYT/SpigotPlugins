package com.vrish.grapple;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Recipe {

    private static Plugin plugin = main.getPlugin(main.class);

    public static ItemStack getGrappleHook() {

        ItemStack grappleHook = new ItemStack(Material.BOW);
        ItemMeta meta = grappleHook.getItemMeta();
        meta.getItemFlags().add(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.setUnbreakable(true);
        meta.setDisplayName("§b§lGrappling Hook");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("   ");
        lore.add("§7§lRight-click§r §7and §lshoot§r §7to send a hook!");
        lore.add("§8§lLeft-click§r §8to pull yourself towards the hook!");
        lore.add("   ");
        lore.add("§4§lRequires 1 arrow in inventory!");
        meta.setLore(lore);
        grappleHook.setItemMeta(meta);
        return grappleHook;

    }

    public static void grappleRecipe(){

        ItemStack grappleHook = getGrappleHook();
        NamespacedKey namespace = new NamespacedKey(plugin, plugin.getDescription().getName() + "grappleRecipe");
        ShapedRecipe craftHook = new ShapedRecipe(namespace, grappleHook);
        craftHook.shape("sGs","*B*","sEs");
        craftHook.setIngredient('s', Material.STRING);
        craftHook.setIngredient('G', Material.SULPHUR);
        craftHook.setIngredient('*', Material.IRON_INGOT);
        craftHook.setIngredient('B', Material.BOW);
        craftHook.setIngredient('E', Material.EYE_OF_ENDER);
        plugin.getServer().addRecipe(craftHook);
    }

}
