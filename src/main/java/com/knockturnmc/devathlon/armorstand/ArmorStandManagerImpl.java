package com.knockturnmc.devathlon.armorstand;

import com.knockturnmc.devathlon.DevAthlon;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;


public class ArmorStandManagerImpl implements ArmorStandManager {

    private DevAthlon devAthlon;
    public ArmorStandManagerImpl (DevAthlon devAthlon) { this.devAthlon = devAthlon; }

    public float step = 11.25f;

    @Override
    public void spawnKeyArmorStand(ItemStack dropStack, Player player, Location keyLoc) {
        Location location = player.getLocation();

        ArmorStand as = (ArmorStand) location.getWorld().spawn(location, ArmorStand.class);
        as.setVisible(false);
        as.setSmall(true);
        as.setGravity(false);
        as.setArms(true);
        as.setCustomName("key");
        as.setCustomNameVisible(false);
        as.setHeadPose(new EulerAngle((float) (185),
                (float) (175),
                (float) (185)));
        as.setHelmet(dropStack);

        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if (i >= 140) {
                    as.getNearbyEntities(8, 8, 8).stream()
                            .filter(e -> e instanceof Player)
                            .forEach(e -> e.teleport(keyLoc));
                    as.remove();
                    this.cancel();
                    return;
                }

                Entity e = as;

                Location loc = as.getLocation();
                loc.setYaw(loc.getYaw() + step);
                as.teleport(loc);

                i++;
            }
        }.runTaskTimer(devAthlon, 05, 01);
    }
}
