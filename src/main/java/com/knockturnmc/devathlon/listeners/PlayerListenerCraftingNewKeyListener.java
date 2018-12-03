package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.keyfactory.BlankKey;
import com.knockturnmc.devathlon.keyfactory.CustomRecipe;
import com.knockturnmc.devathlon.utils.Permissions;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class PlayerListenerCraftingNewKeyListener implements Listener {

    private Permissions perms;
    private CustomRecipe cRecipe;
    private BlankKey bKey;

    public PlayerListenerCraftingNewKeyListener (Permissions perms, CustomRecipe cRecipe, BlankKey bKey) {
        this.perms = perms;
        this.cRecipe = cRecipe;
        this.bKey = bKey;
    }

    @EventHandler
    public  void onItemCraft(CraftItemEvent event) {
        if (event.getInventory() instanceof CraftingInventory) {
            CraftingInventory inv = (CraftingInventory) event.getInventory();
            Player player = (Player) event.getWhoClicked();
            if (inv.getSize() == 4) return;
            if (event.getRecipe().equals(cRecipe.craftKey())) {
                if (player.hasPermission(perms.getUSER_PERMISSION())) {
                    inv.setResult(bKey.blankKey());
                    return;
                } else {
                    event.setCancelled(true);
                    inv.setResult(new ItemStack(Material.AIR));
                    return;
                }
            }
        }
    }

}
