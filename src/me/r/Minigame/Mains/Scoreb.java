package me.r.Minigame.Mains;

import me.r.Minigame.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scoreboard.*;

public class Scoreb implements Listener {


    public static void updateScoreb(Player p) {
        ScoreboardManager sm = Bukkit.getScoreboardManager();
        Scoreboard sb = sm.getNewScoreboard();

        int kills = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Kills");
        int deaths = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Deaths");
        int killstreakCoins = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".KillstreakCoins");


        Objective obj = sb.registerNewObjective("test", "");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);


        obj.setDisplayName(ChatColor.BOLD + "" + ChatColor.DARK_AQUA + "----- STATS ----");
        Score s1 = obj.getScore("            ");
        s1.setScore(7);

        Score name = obj.getScore(ChatColor.BOLD + "" + ChatColor.GRAY + "Name: " + ChatColor.WHITE + p.getDisplayName());
        name.setScore(6);

        Score kills1 = obj.getScore(ChatColor.BOLD + "" + ChatColor.GRAY + "Kills: " + ChatColor.WHITE + kills);
        kills1.setScore(5);

        Score deaths1 = obj.getScore(ChatColor.BOLD + "" + ChatColor.GRAY + "Deaths: " + ChatColor.WHITE + deaths);
        deaths1.setScore(4);

        Score Streak = obj.getScore(ChatColor.BOLD + "" + ChatColor.GRAY + "Streak: " + ChatColor.WHITE + p.getLevel());
        Streak.setScore(3);

        Score ksCoins = obj.getScore(ChatColor.BOLD + "" + ChatColor.GRAY + "KillstreakCoins: " + ChatColor.WHITE + killstreakCoins);
        ksCoins.setScore(2);


        Score s2 = obj.getScore("            ");
        s2.setScore(1);

        p.setScoreboard(sb);


    }

    @EventHandler
    public void onJ(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        updateScoreb(player);


    }

    @EventHandler
    public void onQ(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        updateScoreb(p);

    }

    @EventHandler
    public void onR(PlayerRespawnEvent e) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            updateScoreb(p);
        }
    }

    @EventHandler
    public void onLC(PlayerLevelChangeEvent e) {
        Player p = e.getPlayer();
        updateScoreb(p);

    }

    @EventHandler
    public void onD(PlayerDeathEvent e) {
        Player p = (Player) e.getEntity();
        Player k = p.getKiller();

        updateScoreb(p);
        updateScoreb(k);

    }


}
