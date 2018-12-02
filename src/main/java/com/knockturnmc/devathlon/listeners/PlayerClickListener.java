package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.keyfactory.KeyType;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerClickListener implements Listener {

    private KeyType keyType;

    public PlayerClickListener(KeyType keyType) {
        this.keyType = keyType;
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Player player = event.getPlayer();
        if (!keyType.isKeyEmpty(player.getInventory().getItemInMainHand())) return;
        if (player.getInventory().getItemInMainHand() == null) return;
        ItemStack key = player.getInventory().getItemInMainHand();

        Location loc = player.getLocation();
        double x = Math.round(loc.getX());
        double y = Math.round(loc.getY());
        double z = Math.round(loc.getZ());
        String world = loc.getWorld().getName();

        ItemMeta meta = key.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Portkey");

        List<String> newLore = new ArrayList<String>();
        newLore.add("Portkey");
        newLore.add(ChatColor.GOLD + "" + ChatColor.MAGIC + Double.toString(x));
        newLore.add(ChatColor.GOLD + "" + ChatColor.MAGIC + Double.toString(y));
        newLore.add(ChatColor.GOLD + "" + ChatColor.MAGIC + Double.toString(z));
        newLore.add(ChatColor.GOLD + "" + ChatColor.MAGIC + world);
        meta.setLore(newLore);
        key.setItemMeta(meta);
    }
}
