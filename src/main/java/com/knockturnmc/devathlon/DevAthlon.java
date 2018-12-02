package com.knockturnmc.devathlon;

import com.knockturnmc.devathlon.armorstand.ArmorStandManager;
import com.knockturnmc.devathlon.armorstand.ArmorStandManagerImpl;
import com.knockturnmc.devathlon.listeners.PlayerDropListener;
import com.knockturnmc.devathlon.particles.Particles;
import com.knockturnmc.devathlon.particles.SnekCircleParticlesImpl;
import org.bukkit.plugin.java.JavaPlugin;

public class DevAthlon extends JavaPlugin {

    private Particles shape;
    private SnekCircleParticlesImpl snekCircle;
    private ArmorStandManagerImpl asManagerImpl;

    @Override
    public void onEnable() {
        this.snekCircle = new SnekCircleParticlesImpl(this);
        this.asManagerImpl = new ArmorStandManagerImpl(this);

        getServer().getPluginManager().registerEvents(new PlayerDropListener(this.shape, this), this);
    }

    @Override
    public void onDisable() {
        asManagerImpl.keyArmorStands.forEach(as -> as.remove());
    }


}
