package com.knockturnmc.devathlon.keyfactory;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class KeyTypeImpl implements KeyType {

    @Override
    public boolean isKey(ItemStack key) {
        //if (!key.getItemMeta().hasLore()) return false;
        List<String> lore = key.getItemMeta().getLore();
        if (lore.contains("Portkey")) {
            return true;
        } else{
                return false;
            }
    }
//ChatColor.GOLD + "" + ChatColor.MAGIC  +
    @Override
    public boolean isKeyEmpty(ItemStack key) {
        if (!isKey(key)) return false;
        System.out.print("t");
        List<String> lore = key.getItemMeta().getLore();
        if (lore.contains("Empty")) {
            return true;
        } else {
            return false;
        }

    }
}
