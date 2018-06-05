package com.vrish.grapple;

import io.github.theluca98.textapi.textapi.ActionBar;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static com.vrish.grapple.Recipe.getGrappleHook;

public class Events implements Listener {

    public HashMap<UUID, Location> hooks = new HashMap<>();
    public HashMap<Entity, UUID> players = new HashMap<>();
    public HashMap<UUID, Entity> arrows = new HashMap<>();
    public HashMap<UUID, Entity> bat_leash = new HashMap<>();
    private ArrayList<Player> nofall = new ArrayList<>();

    private Plugin plugin = main.getPlugin(main.class);

    @EventHandler
    public void bowShoot(EntityShootBowEvent shoot) {
        try {
            if (shoot.getBow().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lGrappling Hook")) {

                LivingEntity shooter = shoot.getEntity();
                Entity arrow = shoot.getProjectile();

                if (shooter instanceof Player) {

                    Player p = (Player) shooter;
                    UUID uuid = p.getUniqueId();
                    if (!players.containsValue(uuid) && !arrows.containsKey(uuid)) {
                        players.put(arrow, uuid);
                        arrows.put(uuid, arrow);
                    } else {
                        Entity old_arrow = arrows.get(uuid);
                        arrows.replace(uuid, old_arrow, arrow);
                        players.remove(old_arrow);
                        players.put(arrow, uuid);
                    }
                    World world = shooter.getWorld();
                    Location loc = arrow.getLocation();
                    arrow.setGlowing(true);
                    arrow.setCustomName(p.getName() + "'s Hook");
                    arrow.setCustomNameVisible(false);
                }
            }

        }catch (NullPointerException e ) {
            Logger.logToFile(e.getMessage());
        }
    }

    @EventHandler
    public void arrowLand(ProjectileHitEvent land) {

        if (null == land.getHitEntity()) {
            if (!players.isEmpty()) {

                if (players.containsKey(land.getEntity())) {

                    Location loc = land.getEntity().getLocation();
                    UUID uuid = players.get(land.getEntity());
                    Player p = plugin.getServer().getPlayer(uuid);
                    hooks.remove(uuid);
                    hooks.put(uuid, loc);
                    ActionBar hook_attached = new ActionBar("§2§lHook Attached!");
                    hook_attached.send(plugin.getServer().getPlayer(uuid));
                    if (bat_leash.containsKey(uuid)) {
                        LivingEntity old_bat = (LivingEntity) bat_leash.get(uuid);
                        old_bat.setLeashHolder(null);
                        old_bat.remove();
                        bat_leash.remove(uuid);
                    }
                    Bat bat = (Bat) loc.getWorld().spawnEntity(loc, EntityType.BAT);
                    bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10000, 1));
                    bat.setAI(false);
                    bat.setAwake(false);
                    bat.setGravity(true);
                    bat.setInvulnerable(true);
                    bat.teleport(loc);
                    bat.setLeashHolder(p);
                    bat_leash.put(uuid, bat);
                    Logger.logToFile(p.getName() + " created hook!");
                    if (arrows.containsKey(uuid)) {
                        Entity arrow = arrows.get(uuid);
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                arrow.remove();
                            }
                        }.runTaskLater(plugin, 100);

                    }
                }

            }
        }

    }

    @EventHandler
    public void leftClick(PlayerInteractEvent click) {
        try {
            if (!(null == click.getItem())) {
                if (click.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lGrappling Hook")) {
                    if ((click.getAction().equals(Action.LEFT_CLICK_AIR)) || (click.getAction().equals(Action.LEFT_CLICK_BLOCK))) {

                        Player player = click.getPlayer();
                        UUID uuid = player.getUniqueId();
                        if (hooks.containsKey(uuid)) {
                            Location loc = hooks.get(uuid);
                            hooks.remove(uuid);
                            ActionBar hook = new ActionBar("§2§lGrappling...");
                            hook.send(player);
                            if (bat_leash.containsKey(uuid)) {
                                LivingEntity old_bat = (LivingEntity) bat_leash.get(uuid);
                                old_bat.setLeashHolder(null);
                                old_bat.remove();
                                bat_leash.remove(uuid);
                            }
                            if (!nofall.contains(player)) nofall.add(player);
                            GrapplePull.grapplePull(player,loc);
                            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_MAGMACUBE_JUMP, 10f, 1f);
                            Logger.logToFile(player.getName() + " used grapple hook!");

                        } else {
                            ActionBar no_hook = new ActionBar("§c§lNo hook found!");
                            no_hook.send(player);
                        }
                    }
                }
            }
        }catch (NullPointerException e) {
            Logger.logToFile(e.getMessage());

        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        if (!e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) return;

        Player p = (Player) e.getEntity();

        if (nofall.contains(p)) {
            e.setCancelled(true);
            nofall.remove(p);
        }
    }
}