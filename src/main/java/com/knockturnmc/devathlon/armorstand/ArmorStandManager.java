package com.knockturnmc.devathlon.armorstand;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface ArmorStandManager {
    void spawnKeyArmorStand(ItemStack dropStack, Player player, Location keyLoc);
}
