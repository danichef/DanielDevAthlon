package com.knockturnmc.devathlon;

import com.knockturnmc.devathlon.armorstand.ArmorStandManager;
import com.knockturnmc.devathlon.armorstand.ArmorStandManagerImpl;
import com.knockturnmc.devathlon.commands.AdminCommand;
import com.knockturnmc.devathlon.keyfactory.*;
import com.knockturnmc.devathlon.listeners.PlayerClickListener;
import com.knockturnmc.devathlon.listeners.PlayerCraftingChangeKeyListener;
import com.knockturnmc.devathlon.listeners.PlayerDropListener;
import com.knockturnmc.devathlon.listeners.PlayerListenerCraftingNewKeyListener;
import com.knockturnmc.devathlon.particles.Particles;
import com.knockturnmc.devathlon.particles.SnekCircleParticlesImpl;
import com.knockturnmc.devathlon.utils.Permissions;
import com.knockturnmc.devathlon.utils.PermissionsImpl;
import com.knockturnmc.devathlon.utils.Prefix;
import com.knockturnmc.devathlon.utils.PrefixImpl;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class DevAthlon extends JavaPlugin {

    private Particles shape;
    private ArmorStandManager asManager;
    private KeyType keyType;
    private Prefix prefix;
    private Permissions perms;
    private AdminCommand admcmd;
    private BlankKey bKey;
    private CustomRecipe customRecipe;

    @Override
    public void onEnable() {
        this.bKey = new BlankKeyImpl();
        this.perms = new PermissionsImpl();
        this.prefix = new PrefixImpl();
        this.admcmd = new AdminCommand(this.perms, this.prefix, this.bKey);
        this.keyType = new KeyTypeImpl();
        this.asManager = new ArmorStandManagerImpl(this);
        this.shape = new SnekCircleParticlesImpl(this);
        this.customRecipe = new CustomRecipeImpl(this.bKey);

        getServer().addRecipe(customRecipe.craftKey());

        getServer().getPluginManager().registerEvents(new PlayerDropListener(this.shape, this, this.asManager, this.keyType), this);
        getServer().getPluginManager().registerEvents(new PlayerClickListener(this.keyType), this);
        getServer().getPluginManager().registerEvents(new PlayerCraftingChangeKeyListener(this.perms), this);
        getServer().getPluginManager().registerEvents(new PlayerListenerCraftingNewKeyListener(this.perms, this.customRecipe, this.bKey), this);

        getCommand("dadmin").setExecutor(new AdminCommand(this.perms, this.prefix, this.bKey));
    }

    @Override
    public void onDisable() {
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if ((entity instanceof ArmorStand)) {
                    ArmorStand armor = (ArmorStand) entity;
                    if (!armor.getCustomName().equals("key")) return;
                    armor.remove();
                }
            }
        }
    }


}
