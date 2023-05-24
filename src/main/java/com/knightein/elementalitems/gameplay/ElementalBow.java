package com.knightein.elementalitems.gameplay;

import com.destroystokyo.paper.ParticleBuilder;
import com.knightein.elementalitems.ElementalItems;
import com.knightein.elementalitems.command.GetElementalBows;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ElementalBow implements Listener {

    private static final NamespacedKey key =
            new NamespacedKey(ElementalItems.getInstance(), "bow-type");

    public void createBows(Player player, GetElementalBows.BowType bowName) {
        // Global Stuff
        ItemStack bow = new ItemStack(Material.BOW);

        switch (bowName) {
            case LAVA -> {
                ItemMeta lavaBowMeta = bow.getItemMeta();

                lavaBowMeta.displayName(MiniMessage.miniMessage().deserialize(
                        "<b><gradient:#ff000d:#ffaa00>Lava Bow"));

                List<Component> lore = List.of(
                        MiniMessage.miniMessage().deserialize(
                                ""),
                        MiniMessage.miniMessage().deserialize(
                                "<b><gradient:#ff000d:#ffaa00>Drop Lava On Your Enemies!")
                );
                lavaBowMeta.lore(lore);

                lavaBowMeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
                addEnchants(lavaBowMeta);

                setKey(lavaBowMeta, key, "lava");

                bow.setItemMeta(lavaBowMeta);
                player.getInventory().addItem(bow);
            }
            case LIGHTNING -> {
                ItemMeta lightningBowMeta = bow.getItemMeta();

                lightningBowMeta.displayName(MiniMessage.miniMessage().deserialize(
                        "<b><gradient:#17fffb:#0091ff>Lightning Bow"));

                List<Component> lore = List.of(
                        MiniMessage.miniMessage().deserialize(
                                ""),
                        MiniMessage.miniMessage().deserialize(
                                "<b><gradient:#17fffb:#0091ff>Shock Your Enemies!")
                );
                lightningBowMeta.lore(lore);

                addEnchants(lightningBowMeta);

                setKey(lightningBowMeta, key, "lightning");

                bow.setItemMeta(lightningBowMeta);
                player.getInventory().addItem(bow);
            }
            case ICE -> {
                ItemMeta iceBowMeta = bow.getItemMeta();

                iceBowMeta.displayName(MiniMessage.miniMessage().deserialize(
                        "<b><gradient:#00fffc:#e0f1ff>Ice Bow"));

                List<Component> lore = List.of(
                        MiniMessage.miniMessage().deserialize(
                                ""),
                        MiniMessage.miniMessage().deserialize(
                                "<b><gradient:#00fffc:#e0f1ff>Freeze Your Enemies!")
                );
                iceBowMeta.lore(lore);

                addEnchants(iceBowMeta);

                setKey(iceBowMeta, key, "ice");

                bow.setItemMeta(iceBowMeta);
                player.getInventory().addItem(bow);
            }
            case WIND -> {
                ItemMeta windBowMeta = bow.getItemMeta();

                windBowMeta.displayName(MiniMessage.miniMessage().deserialize(
                        "<b><gradient:#ffef61:#fff200>Wind Bow"));

                List<Component> lore = List.of(
                        MiniMessage.miniMessage().deserialize(
                                ""),
                        MiniMessage.miniMessage().deserialize(
                                "<b><gradient:#ffef61:#fff200>Blow Your Enemies Away!")
                );
                windBowMeta.lore(lore);

                addEnchants(windBowMeta);

                setKey(windBowMeta, key, "wind");

                bow.setItemMeta(windBowMeta);
                player.getInventory().addItem(bow);
            }
            case WOLF -> {
                ItemMeta wolfBowMeta = bow.getItemMeta();

                wolfBowMeta.displayName(MiniMessage.miniMessage().deserialize(
                        "<b><gradient:#fbffeb:#9ea194>Wolf Bow"));

                List<Component> lore = List.of(
                        MiniMessage.miniMessage().deserialize(
                                ""),
                        MiniMessage.miniMessage().deserialize(
                                "<b><gradient:#fbffeb:#9ea194>Summon Wolves To Fight For You!")
                );
                wolfBowMeta.lore(lore);

                addEnchants(wolfBowMeta);

                setKey(wolfBowMeta, key, "wolf");

                bow.setItemMeta(wolfBowMeta);
                player.getInventory().addItem(bow);
            }
            case ENDER -> {
                ItemMeta enderBowMeta = bow.getItemMeta();

                enderBowMeta.displayName(MiniMessage.miniMessage().deserialize(
                        "<b><gradient:#ff00ff:#ff00a9>Ender Bow"));

                List<Component> lore = List.of(
                        MiniMessage.miniMessage().deserialize(
                                ""),
                        MiniMessage.miniMessage().deserialize(
                                "<b><gradient:#ff00ff:#ff00a9>Teleport Away!")
                );
                enderBowMeta.lore(lore);

                addEnchants(enderBowMeta);

                setKey(enderBowMeta, key, "ender");

                bow.setItemMeta(enderBowMeta);
                player.getInventory().addItem(bow);
            }
            case CREEPER -> {
                ItemMeta creeperBowMeta = bow.getItemMeta();

                creeperBowMeta.displayName(MiniMessage.miniMessage().deserialize(
                        "<b><gradient:#00ff00:#00a900>Creeper Bow"));

                List<Component> lore = List.of(
                        MiniMessage.miniMessage().deserialize(
                                ""),
                        MiniMessage.miniMessage().deserialize(
                                "<b><gradient:#00ff00:#00a900>Explode Your Enemies!")
                );
                creeperBowMeta.lore(lore);

                addEnchants(creeperBowMeta);

                setKey(creeperBowMeta, key, "creeper");

                bow.setItemMeta(creeperBowMeta);
                player.getInventory().addItem(bow);
            }
            case NECROMANCER -> {
                ItemMeta villainBowMeta = bow.getItemMeta();

                villainBowMeta.displayName(MiniMessage.miniMessage().deserialize(
                        "<b><gradient:#ff0000:#a90000>Necromancer Bow"));

                List<Component> lore = List.of(
                        MiniMessage.miniMessage().deserialize(
                                ""),
                        MiniMessage.miniMessage().deserialize(
                                "<b><gradient:#ff0000:#a90000>Summon Mobs of the Dead!")
                );
                villainBowMeta.lore(lore);

                addEnchants(villainBowMeta);

                setKey(villainBowMeta, key, "necromancer");

                bow.setItemMeta(villainBowMeta);
                player.getInventory().addItem(bow);
            }
            default -> {
                player.sendMessage(MiniMessage.miniMessage().deserialize(
                        "<b><red>Bow not found!"));
            }
        }
        player.sendMessage(MiniMessage.miniMessage().deserialize(
                "<b><green>Successfully gave " + player.getName() + " a " + bowName + " Bow"));
    }

    private void addEnchants(ItemMeta meta) {
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    }

    private void setKey(ItemMeta meta, NamespacedKey key, String value) {
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, value);
    }

    private static String getKey(ItemMeta itemMeta, NamespacedKey key) {
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();
        if (container.has(key, PersistentDataType.STRING)) {
            return container.get(key, PersistentDataType.STRING);
        }
        return null;
    }

    private static void elementalParticles(@NotNull Entity entity, @NotNull Particle particle,
                                           boolean colorReq, int red, int green, int blue, int count, double offsetAll) {
        AtomicInteger counter = new AtomicInteger(0);
        Bukkit.getScheduler().runTaskTimer(ElementalItems.getPlugin(ElementalItems.class), (task) -> {

            if (!colorReq) {
                new ParticleBuilder(particle)
                        .allPlayers() // Sends particle to all players.
                        .count(count) // Amount of particles.
                        .offset(offsetAll, offsetAll, offsetAll) // Offset of the particle.
                        .location(entity.getLocation().clone().add(0, 1, 0)) // Location of the particle.
                        .spawn();
                task.cancel();
                return;
            }
            new ParticleBuilder(particle)
                    .color(red, green, blue) // Color of the particle.
                    .allPlayers() // Sends particle to all players.
                    .count(count) // Amount of particles.
                    .offset(offsetAll, offsetAll, offsetAll) // Offset of the particle.
                    .location(entity.getLocation().clone().add(0, 1, 0)) // Location of the particle.
                    .spawn();
            task.cancel();
        }, 0, 20L);
    }

    public static class Events implements Listener {
        @EventHandler
        public void onHit(ProjectileHitEvent event) {
            if (event.getEntity().getType() == EntityType.ARROW) {

                Entity arrow = event.getEntity();
                Player player = (Player) event.getEntity().getShooter();
                if (player == null) return;
                ItemMeta bowMeta = player.getInventory().getItemInMainHand().getItemMeta();
                Location arrowLoc = arrow.getLocation();
                String itemKey = getKey(bowMeta, key);
                if (itemKey == null) return;

                switch (GetElementalBows.BowType.valueOf(itemKey.toUpperCase())) {
                    case LAVA -> {
                        Location lavaLoc = arrowLoc.add(0, 0, 0);
                        arrow.getWorld().getBlockAt(lavaLoc).setType(Material.LAVA);
                    }
                    case LIGHTNING -> {
                        arrow.getWorld().strikeLightning(arrowLoc);
                    }
                    case ICE -> {
                        if (event.getHitEntity() != null) {
                            ((LivingEntity) event.getHitEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 50));
                        } else if (event.getHitBlock() != null) {
                            event.getHitBlock().setType(Material.ICE);
                            if (event.getHitBlock().getRelative(BlockFace.UP).getType() == Material.LAVA ||
                                    event.getHitBlock().getRelative(BlockFace.UP).getType() == Material.WATER) {
                                event.getHitBlock().getRelative(BlockFace.UP).setType(Material.ICE);
                            }
                        }
                        elementalParticles(arrow, Particle.REDSTONE, true,
                                140, 140, 255, 100, 0.5);
                    }
                    case WIND -> {
                        if (event.getHitEntity() != null) {
                            ((LivingEntity) event.getHitEntity()).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 10, 30));
                        }
                        elementalParticles(arrow, Particle.REDSTONE, true,
                                255, 255, 100, 100, 0.5);
                    }
                    case WOLF -> {
                        for (int i = 0; i < 3; i++) {
                            Wolf wolf = (Wolf) arrow.getWorld().spawnEntity(arrowLoc, EntityType.WOLF);
                            wolf.setOwner(player);
                        }
                    }
                    case ENDER -> {
                        Block newPlayerLoc = arrow.getWorld().getBlockAt(arrowLoc);
                        player.teleport(newPlayerLoc.getLocation().add(0, 1, 0));
                        elementalParticles(arrow, Particle.REDSTONE, true,
                                255, 0, 255, 100, 0.5);
                    }
                    case CREEPER -> {
                        arrow.getWorld().createExplosion(arrowLoc, 2);
                    }
                    case NECROMANCER -> {
                        for (int i = 0; i < 2; i++) {
                            Skeleton skeleton = (Skeleton) arrow.getWorld().spawnEntity(arrowLoc, EntityType.SKELETON);
                            skeleton.customName(MiniMessage.miniMessage().deserialize(
                                    "<b><gradient:#ff0000:#a90000>Skeleton Minion"));
                            skeleton.setCustomNameVisible(true);
                            LivingEntity livingEntity = (LivingEntity) event.getHitEntity();
                            if (livingEntity == null) {
                                skeleton.setTarget(player);
                            } else {
                                skeleton.setTarget(livingEntity);
                            }
                            skeleton.setCanPickupItems(false);
                            skeleton.setRemoveWhenFarAway(true);
                            skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
                            skeleton.getEquipment().setItemInMainHandDropChance(0);
                            skeleton.getEquipment().setItemInOffHand(new ItemStack(Material.DIAMOND_SWORD));
                            skeleton.getEquipment().setItemInOffHandDropChance(0);
                            skeleton.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                            skeleton.getEquipment().setHelmetDropChance(0);
                            skeleton.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                            skeleton.getEquipment().setChestplateDropChance(0);
                            skeleton.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                            skeleton.getEquipment().setLeggingsDropChance(0);
                            skeleton.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                            skeleton.getEquipment().setBootsDropChance(0);
                        }
                    }
                }
            }
        }
    }
}
