package com.knockturnmc.devathlon;

import com.knockturnmc.devathlon.armorstand.ArmorStandManager;
import com.knockturnmc.devathlon.listeners.PlayerDropListener;
import com.knockturnmc.devathlon.particles.Particles;
import com.knockturnmc.devathlon.particles.SnekCircleParticlesImpl;
import org.bukkit.plugin.java.JavaPlugin;

public class DevAthlon extends JavaPlugin {

    private Particles shape;
    private SnekCircleParticlesImpl snekCircle;
    private ArmorStandManager asManager;

    @Override
    public void onEnable() {
        this.snekCircle = new SnekCircleParticlesImpl(this);
        this.asManager = new ArmorStandManager(this);

        getServer().getPluginManager().registerEvents(new PlayerDropListener(this.shape, this), this);
    }

    @Override
    public void onDisable() {
        asManager.keyArmorStands.forEach(as -> as.remove());
    }


}
