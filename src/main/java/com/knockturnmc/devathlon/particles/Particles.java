package com.knockturnmc.devathlon.particles;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface Particles {

    /**
     * Spawns some circle formed by snakes in player location
     * @param location
     */
    void keyEffect(Location location);
}
