package me.r.Minigame.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    // private List<String> team = new ArrayList<String>();


    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (p instanceof Player) {
            if ((!p.getInventory().contains(Material.AIR)) || p.getInventory().contains(Material.AIR)) {
                p.getInventory().clear();
            }
        }

    }


}
