package com.knockturnmc.devathlon;

import com.knockturnmc.devathlon.listeners.PlayerDropListener;
import com.knockturnmc.devathlon.particles.Particles;
import com.knockturnmc.devathlon.particles.SnekCircleParticlesImpl;
import org.bukkit.plugin.java.JavaPlugin;

public class DevAthlon extends JavaPlugin {

    private Particles shape;
    private SnekCircleParticlesImpl snekCircle;

    @Override
    public void onEnable() {
        this.snekCircle = new SnekCircleParticlesImpl(this);

        getServer().getPluginManager().registerEvents(new PlayerDropListener(this.shape, this), this);
    }


}
