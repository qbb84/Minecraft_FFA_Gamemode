package me.r.Minigame.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PlayerDeath implements Listener {


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player player = (Player) e.getEntity().getKiller();
        p.setLevel(0);
        e.setDroppedExp(0);
        p.getWorld().createExplosion(p.getLocation(), 1);
        if (e.getEntity() instanceof Player) {
            if (p.getKiller() instanceof Player) {


                Bukkit.broadcastMessage(p.getName() + " " + ChatColor.AQUA + "Has been killed by " + player.getName());

                e.setDeathMessage("");

            }


        } else {
            return;
        }


    }


}
