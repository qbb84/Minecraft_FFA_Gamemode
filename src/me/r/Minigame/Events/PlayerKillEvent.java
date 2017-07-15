package me.r.Minigame.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillEvent implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player player = (Player) e.getEntity().getKiller();
        if (e.getEntity() instanceof Player) {
            if (p.getKiller() instanceof Player) {
                p.getKiller().sendMessage(ChatColor.GOLD + "You have killed " + p.getName());
                p.getKiller().giveExpLevels(1);
                e.setDeathMessage("");
                // p.getKiller().setHealth(p.getKiller().getHealth() + 4);
            }
        }
    }
}
