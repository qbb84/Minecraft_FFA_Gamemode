package me.r.Minigame.Events;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class EntityDEvent implements Listener {

    public ArrayList<String> evade = new ArrayList<String>();


    @EventHandler
    public void onHit(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
        double health = p.getHealth();
        if (p instanceof Player) {
            if (p.getLevel() == 5 || p.getLevel() == 10 || p.getLevel() == 15 || p.getLevel() == 20 || p.getLevel() == 25 ||
                    p.getLevel() == 30 || p.getLevel() == 35 || p.getLevel() == 40 || p.getLevel() == 45 || p.getLevel() == 50) {
                //TODO


            }

        }

    }
}


