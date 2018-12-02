package com.knockturnmc.devathlon.keyfactory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BlankKeyImpl implements BlankKey {

    @Override
    public ItemStack giveBlankKey () {
        ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = key.getItemMeta();

        ArrayList<String> Lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.WHITE +  "Blank Portkey");
        Lore.add("Portkey");
        Lore.add(ChatColor.GOLD + "" + ChatColor.MAGIC  + "Empty");
        meta.setLore(Lore);

        key.setItemMeta(meta);

        return  key;
    }
}
