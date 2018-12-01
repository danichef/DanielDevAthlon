package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.DevAthlon;
import com.knockturnmc.devathlon.armorstand.ArmorStandManager;
import com.knockturnmc.devathlon.particles.Particles;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerDropListener implements Listener {
    private Particles shape;
    private DevAthlon devAthlon;
    private ArmorStandManager asManager;
    public PlayerDropListener (Particles shape, DevAthlon devAthlon) { this.shape = shape; this.devAthlon = devAthlon;}

    @EventHandler
    public void onClick(PlayerDropItemEvent event) {
        ItemMeta dropMeta = event.getItemDrop().getItemStack().getItemMeta();
        if (dropMeta.getLore() == null) return;
        if (!dropMeta.getLore().contains("Portkey")) return;

        event.getItemDrop().remove();
        Player player = event.getPlayer();
        shape.keyEffect(player);
    }

}
