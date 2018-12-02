package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.DevAthlon;
import com.knockturnmc.devathlon.armorstand.ArmorStandManager;
import com.knockturnmc.devathlon.armorstand.ArmorStandManagerImpl;
import com.knockturnmc.devathlon.particles.Particles;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class PlayerDropListener implements Listener {
    private Particles shape;
    private DevAthlon devAthlon;
    private ArmorStandManagerImpl asManager;
    public PlayerDropListener (Particles shape, DevAthlon devAthlon, ArmorStandManagerImpl asManager) {
        this.shape = shape;
        this.devAthlon = devAthlon;
        this.asManager = asManager;
    }

    @EventHandler
    public void onClick(PlayerDropItemEvent event) {
        ItemMeta dropMeta = event.getItemDrop().getItemStack().getItemMeta();
        if (dropMeta.getLore() == null) return;
        if (!dropMeta.getLore().contains("Portkey")) return;
        if (dropMeta.getLore().contains(ChatColor.GOLD + "" + ChatColor.MAGIC  + "Empty")) return;
        event.getItemDrop().remove();
        Player player = event.getPlayer();
        Location location = player.getLocation();

        asManager.spawnKeyArmorStand(event.getItemDrop().getItemStack(), player);

        new BukkitRunnable() {
            @Override
            public void run() {
                shape.keyEffect(player, location);
            }
        }.runTaskLater(devAthlon, 20);
    }

}
