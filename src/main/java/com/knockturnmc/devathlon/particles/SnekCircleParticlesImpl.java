package com.knockturnmc.devathlon.particles;

import com.knockturnmc.devathlon.DevAthlon;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SnekCircleParticlesImpl implements Particles {

    private DevAthlon devAthlon;
    public SnekCircleParticlesImpl (DevAthlon devAthlon) { this.devAthlon = devAthlon; }

    /**
     * Spawns some circle formed by snakes in player location
     * @param player
     */
    @Override
    public void keyEffect(Player player) {
        new BukkitRunnable(){
            double time = Math.PI/4;
            Location location = player.getLocation();

            @Override
            public void run(){
                time = time + 0.02 * Math.PI;
                for (double i = 0; i <= 2*Math.PI; i = i + Math.PI/32){
                    double x = time * Math.cos(i);
                    double y = 2 * Math.exp(-0.1*time) * Math.sin(time) + 1.5;
                    double z = time * Math.sin(i);
                    location.add(x,y,z);
                    player.spawnParticle(Particle.FIREWORKS_SPARK, location,0,0,0,0,1);
                    location.subtract(x,y,z);

                    i = i + Math.PI/64;

                    x = time*Math.cos(i);
                    y = 2*Math.exp(-0.1*time) * Math.sin(time) + 1.5;
                    z = time*Math.sin(i);
                    location.add(x,y,z);
                    player.getPlayer().spawnParticle(Particle.SPELL_WITCH, location,0,0,0,0,1);
                    location.subtract(x,y,z);
                }
                if (time > 6){
                    this.cancel();
                }
            }
        }.runTaskTimer(devAthlon, 0,1);
    }
}
