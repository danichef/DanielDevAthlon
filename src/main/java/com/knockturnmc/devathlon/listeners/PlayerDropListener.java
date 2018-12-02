package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.DevAthlon;
import com.knockturnmc.devathlon.armorstand.ArmorStandManager;
import com.knockturnmc.devathlon.keyfactory.KeyType;
import com.knockturnmc.devathlon.particles.Particles;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class PlayerDropListener implements Listener {
    private Particles shape;
    private DevAthlon devAthlon;
    private ArmorStandManager asManager;
    private KeyType keyType;
    public PlayerDropListener (Particles shape, DevAthlon devAthlon, ArmorStandManager asManager, KeyType keyType) {
        this.shape = shape;
        this.devAthlon = devAthlon;
        this.asManager = asManager;
        this.keyType = keyType;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        ItemStack drop = event.getItemDrop().getItemStack();
        ItemMeta dropMeta = drop.getItemMeta();
        if (keyType.isKeyEmpty(drop)) return;
        Player player = event.getPlayer();
        Location location = player.getLocation();

        List<String> lore = dropMeta.getLore();
        double x = new Double(ChatColor.stripColor(lore.get(1)));
        double y = new Double(ChatColor.stripColor(lore.get(2)));
        double z = new Double(ChatColor.stripColor(lore.get(3)));
        World w = Bukkit.getServer().getWorld(ChatColor.stripColor(lore.get(4)));
        Location keyLoc = new Location(w, x, y, z);

        asManager.spawnKeyArmorStand(event.getItemDrop().getItemStack(), player, keyLoc);
        event.getItemDrop().remove();

        new BukkitRunnable() {
            @Override
            public void run() {
                shape.keyEffect(location);
            }
        }.runTaskLater(devAthlon, 40);
    }

}
