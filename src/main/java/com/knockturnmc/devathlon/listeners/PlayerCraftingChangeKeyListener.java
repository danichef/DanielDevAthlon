package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.keyfactory.CustomRecipe;
import com.knockturnmc.devathlon.utils.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerCraftingChangeKeyListener implements Listener {

    private CustomRecipe cRecipe;
    private Permissions perms;

    public PlayerCraftingChangeKeyListener(CustomRecipe cRecipe, Permissions perms) {
        this.cRecipe = cRecipe;
        this.perms = perms;
    }

    @EventHandler
    public  void onItemCraft(CraftItemEvent event) {
        if(event.getInventory() instanceof CraftingInventory) {
            CraftingInventory inv = (CraftingInventory) event.getInventory();
            Player player = (Player) event.getWhoClicked();
            if(inv.getSize() == 4) return;
            if (event.getRecipe().equals(cRecipe.craftKey())) {
                if (player.hasPermission(perms.getUSER_PERMISSION())) {
                    ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK);
                    ItemMeta meta = key.getItemMeta();
                    ArrayList<String> Lore = new ArrayList<String>();
                    meta.setDisplayName(ChatColor.WHITE + "Blank Portkey");
                    Lore.add("Portkey");
                    Lore.add(ChatColor.GOLD + "" + ChatColor.MAGIC + "Empty");
                    meta.setLore(Lore);
                    key.setItemMeta(meta);
                    inv.setResult(key);
                    return;
                } else {
                    event.setCancelled(true);
                    inv.setResult(new ItemStack(Material.AIR));
                    return;
                }

            } else {
                ItemStack key = null;
                ItemStack block = null;

                for (ItemStack is : inv) {
                    if (is != null) {
                        if (is.getItemMeta().hasLore() && is.getItemMeta().getLore().contains("Portkey") && !inv.getResult().getType().equals(Material.TRIPWIRE_HOOK)) {
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
