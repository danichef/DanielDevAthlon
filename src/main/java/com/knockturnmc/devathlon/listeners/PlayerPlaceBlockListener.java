package com.knockturnmc.devathlon.listeners;

import com.knockturnmc.devathlon.keyfactory.KeyType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceBlockListener implements Listener {

    private KeyType kType;

    public PlayerPlaceBlockListener (KeyType kType) {
        this.kType = kType;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (kType.isKey(player.getInventory().getItemInMainHand())) { event.setCancelled(true); }
    }
}
