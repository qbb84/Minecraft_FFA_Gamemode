package me.r.Minigame.Stats;

import de.Herbystar.TTA.TTA_Methods;
import me.r.Minigame.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatsData implements Listener {
    @EventHandler
    public void on(PlayerDeathEvent e) {
        Player p = (Player) e.getEntity();
        Player k = (Player) p.getKiller();
        int kills = Main.getInstance().getConfig().getInt("Stats." + k.getName() + ".Kills");
        int deaths = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Deaths");
        int killsstreakCoins = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".KillstreakCoins");

        Main.getInstance().getConfig().set("Stats." + p.getName() + ".Deaths", deaths + 1);
        Main.getInstance().getConfig().set("Stats." + k.getName() + ".Kills", kills + 1);


        if (killsstreakCoins != 0) {
            Main.getInstance().getConfig().set("Stats." + p.getName() + ".KillstreakCoins", killsstreakCoins - 1);
            TTA_Methods.sendActionBar(p, Main.color("&e -1 KillstreakCoins! "), 55);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!(p.hasPlayedBefore())) {
            Main.getInstance().getConfig().addDefault("Stats." + p.getName() + ".Kills", Integer.valueOf(0));
            Main.getInstance().getConfig().addDefault("Stats." + p.getName() + ".Deaths", Integer.valueOf(0));
            Main.getInstance().getConfig().addDefault("Stats." + p.getName() + ".KillstreakCoins", Integer.valueOf(0));
        }
    }


}
