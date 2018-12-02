package com.knockturnmc.devathlon.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerCraftingChangeKeyListener implements Listener {

    @EventHandler
    public  void onItemCraft(PrepareItemCraftEvent event) {
        if(event.getInventory() instanceof CraftingInventory) {
            CraftingInventory inv = (CraftingInventory) event.getInventory();
            if(inv.getSize() == 4) return;

            List<ItemStack> craftItems = new ArrayList<ItemStack>();
            ItemStack key = null;
            ItemStack block = null;

            for (ItemStack is : inv) {
                if (is != null) {
                    if (is.getItemMeta().hasLore() && is.getItemMeta().getLore().contains("Portkey")) {
                        key = is;
                    } else {
                        block = is;
                    }
                }
            }

            if (key == null || block == null) return;

            ItemStack newKey = new ItemStack(block.getType());
            List<String> lore = key.getItemMeta().getLore();
            String name = key.getItemMeta().getDisplayName();
            ItemMeta metaKey = newKey.getItemMeta();
            metaKey.setLore(lore);
            metaKey.setDisplayName(name);
            newKey.setItemMeta(metaKey);

            inv.setResult(newKey);

        }
    }
}
