package me.r.Minigame.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class cancelMob implements Listener {

    @EventHandler
    public void onEntity(CreatureSpawnEvent e) {
        e.setCancelled(true);

    }
}
