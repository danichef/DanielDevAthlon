package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.keyfactory.CustomRecipe;
import com.knockturnmc.devathlon.utils.Permissions;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class PlayerCraftingNewKeyListener implements Listener {

    private CustomRecipe cRecipe;
    private Permissions perms;

    public PlayerCraftingNewKeyListener (CustomRecipe cRecipe, Permissions perms) {
        this.cRecipe = cRecipe;
        this.perms = perms;
    }

    @EventHandler
    public void craft(CraftItemEvent event) {
        if (event.getInventory() instanceof CraftingInventory) {
            Player player = (Player) event.getWhoClicked();
            CraftingInventory inv = (CraftingInventory) event.getInventory();
            if (inv.getSize() != 4 && event.getRecipe().equals(cRecipe.craftKey()) && player.hasPermission(perms.getUSER_PERMISSION())) return;
                event.setCancelled(true);
                inv.setResult(new ItemStack(Material.AIR));
            }
    }
}
