package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.keyfactory.BlankKey;
import com.knockturnmc.devathlon.keyfactory.CustomRecipe;
import com.knockturnmc.devathlon.utils.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerCraftingChangeKeyListener implements Listener {

    private Permissions perms;

    public PlayerCraftingChangeKeyListener(Permissions perms) {
        this.perms = perms;
    }

    @EventHandler
    public  void onItemCraft(PrepareItemCraftEvent event) {
        if (event.getInventory() instanceof CraftingInventory) {
            CraftingInventory inv = (CraftingInventory) event.getInventory();

            HumanEntity human = event.getView().getPlayer();
            if (human instanceof Player) {
                Player player = (Player) human;
                ItemStack key = null;
                ItemStack block = null;

                if (!player.hasPermission(perms.getUSER_PERMISSION())) return;

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
}
