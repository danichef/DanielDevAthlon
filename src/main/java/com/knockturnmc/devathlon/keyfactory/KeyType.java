package com.knockturnmc.devathlon.keyfactory;

import org.bukkit.inventory.ItemStack;

public interface KeyType {
    boolean isKey(ItemStack key);

    boolean isKeyEmpty(ItemStack key);
}
