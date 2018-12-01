package com.knockturnmc.devathlon.armorstand;

import com.knockturnmc.devathlon.DevAthlon;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArmorStandManager {

    private DevAthlon devAthlon;
    public ArmorStandManager (DevAthlon devAthlon) { this.devAthlon = devAthlon; }

    private Random r = new Random();

    public List<ArmorStand> keyArmorStands = new ArrayList<ArmorStand>();

    public void spawnKeyArmorStand(ItemStack dropStack, Player player) {
        Location location = player.getLocation();

        ArmorStand as = (ArmorStand) location.getWorld().spawn(location, ArmorStand.class);
        as.setVisible(false);
        as.setSmall(true);
        as.setGravity(false);
        as.setArms(true);
        as.setHeadPose(new EulerAngle((float) (r.nextInt(360)),
                (float) (r.nextInt(360)),
                (float) (r.nextInt(360))));
        as.setHelmet(dropStack);

        keyArmorStands.add(as);

        new BukkitRunnable() {
            int i = 0;

            @Override
            public void run() {
                if (i >= 100) {
                    as.remove();
                    this.cancel();
                    return;
                }

                as.setHeadPose(new EulerAngle((float) (r.nextInt(360)),
                        (float) (r.nextInt(360)),
                        (float) (r.nextInt(360))));
                i++;
            }
        }.runTaskTimer(devAthlon, 05,05);
    }
}
