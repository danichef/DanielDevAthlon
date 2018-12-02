package com.knockturnmc.devathlon.keyfactory;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class KeySetLocationImpl implements KeySetLocation {

    @Override
    public void setKeyLocation(Player player) {
        if (player.getInventory().getItemInMainHand() == null) return;
        ItemStack key = player.getInventory().getItemInMainHand();
        if (!key.getItemMeta().hasLore()) return;
        List<String> lore = key.getItemMeta().getLore();
        if (!lore.contains("Portkey") && !lore.contains(ChatColor.GOLD + "" + ChatColor.MAGIC + "Empty")) return;

        Location loc = player.getLocation();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        String world = loc.getWorld().getName();

        key.getItemMeta().setDisplayName(ChatColor.DARK_PURPLE + "Portkey");

        List<String> newLore = new ArrayList<String>();
        newLore.add("Portkey");
        newLore.add(ChatColor.GOLD + Double.toString(x));
        newLore.add(ChatColor.GOLD + Double.toString(y));
        newLore.add(ChatColor.GOLD + Double.toString(z));
        newLore.add(ChatColor.GOLD + world);
        key.getItemMeta().setLore(newLore);

    }
}
