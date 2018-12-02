package com.knockturnmc.devathlon;

import com.knockturnmc.devathlon.armorstand.ArmorStandManager;
import com.knockturnmc.devathlon.armorstand.ArmorStandManagerImpl;
import com.knockturnmc.devathlon.commands.AdminCommand;
import com.knockturnmc.devathlon.keyfactory.*;
import com.knockturnmc.devathlon.listeners.PlayerClickListener;
import com.knockturnmc.devathlon.listeners.PlayerDropListener;
import com.knockturnmc.devathlon.particles.Particles;
import com.knockturnmc.devathlon.particles.SnekCircleParticlesImpl;
import com.knockturnmc.devathlon.utils.Permissions;
import com.knockturnmc.devathlon.utils.Prefix;
import org.bukkit.plugin.java.JavaPlugin;

public class DevAthlon extends JavaPlugin {

    private Particles shape;
    private SnekCircleParticlesImpl snekCircle;
    private ArmorStandManager asManager;
    private ArmorStandManagerImpl asManagerImpl;
    private KeyType keyType;
    private Prefix prefix;
    private Permissions perms;
    private AdminCommand admcmd;
    private PlayerClickListener clickListerner;
    private PlayerDropListener dropListerner;

    @Override
    public void onEnable() {
        this.snekCircle = new SnekCircleParticlesImpl(this);
        this.asManagerImpl = new ArmorStandManagerImpl(this);
        this.admcmd = new AdminCommand(this.perms, this.prefix);
        this.clickListerner = new PlayerClickListener(this.keyType);
        this.dropListerner = new PlayerDropListener(this.shape, this, this.asManager, this.keyType);
        this.keyType = new KeyTypeImpl();


        getServer().getPluginManager().registerEvents(new PlayerDropListener(this.shape, this, this.asManager, this.keyType), this);
        getServer().getPluginManager().registerEvents(new PlayerClickListener(this.keyType), this);

        getCommand("dadmin").setExecutor(new AdminCommand(this.perms, this.prefix));
    }

    @Override
    public void onDisable() {
        asManagerImpl.keyArmorStands.forEach(as -> as.remove());
    }


}
