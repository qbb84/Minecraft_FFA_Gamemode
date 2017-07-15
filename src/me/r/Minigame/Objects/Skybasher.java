package me.r.Minigame.Objects;

import de.Herbystar.TTA.TTA_Methods;
import me.r.Minigame.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Skybasher implements Listener {

    ArrayList<String> skybaherCheck = new ArrayList<>();

    private int x;

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        Player p = (Player) e.getEntity();
        if(skybaherCheck.contains(p.getName())){
            Random rand = new Random();
            int percent = rand.nextInt(100) +1;
            if(percent <= 20){
                p.getPlayer().getInventory().setHelmet(new ItemStack(Material.TNT));
                p.setVelocity(new Vector(0,20,0).normalize());
                new BukkitRunnable(){
                    public void run(){
                        for(x =5; x>=0;x--){
                            TTA_Methods.sendTitle(p, "" + x,0,x,0,null,0,0,0);
                            if (x == 0){
                                p.getWorld().createExplosion(p.getLocation(), 1);
                                p.getInventory().setHelmet(new ItemStack(Material.AIR));
                                p.setHealth(0.0);
                                p.sendMessage("YOU GOT KAMAKAZEED!");
                                skybaherCheck.remove(p.getName());
                                return;
                            }
                        }

                    }
                }.runTaskTimerAsynchronously(Main.getInstance(), 0, 15);

            }

        }

    }
    @EventHandler
    public void onHit(PlayerDeathEvent e){
        Player p = e.getEntity();
        if(p instanceof Player){
            if(skybaherCheck.contains(p.getName())) {
                skybaherCheck.remove(p.getName());
            }
        }

    }

}