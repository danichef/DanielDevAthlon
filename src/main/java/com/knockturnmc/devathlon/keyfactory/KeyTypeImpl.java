package com.knockturnmc.devathlon.keyfactory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class KeyTypeImpl implements KeyType {

    @Override
    public boolean isKey(ItemStack key) {
        if (key.getType() == Material.AIR) return false;
        if (key.getItemMeta().hasLore()) return false;
        List<String> lore = key.getItemMeta().getLore();
        if (lore.contains("Portkey")) {
            return true;
        } else{
                return false;
            }
    }

    @Override
    public boolean isKeyEmpty(ItemStack key) {
        if (!isKey(key)) return false;
        List<String> lore = key.getItemMeta().getLore();
        if (lore.contains(ChatColor.GOLD + "" + ChatColor.MAGIC + "Empty")) {
            return true;
        } else {
            return false;
        }

    }
}
