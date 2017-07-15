package me.r.Minigame;

import api.bapi.rewind.bapiManager;
import me.r.Minigame.Commands.GuiCommand;
import me.r.Minigame.Commands.perkGUI;
import me.r.Minigame.Events.*;
import me.r.Minigame.Mains.KitItems;
import me.r.Minigame.Mains.Scoreb;
import me.r.Minigame.Stats.Resetstats;
import me.r.Minigame.Stats.Stats;
import me.r.Minigame.Stats.StatsData;
import me.r.Minigame.Stats.addStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Random;


public class Main extends JavaPlugin implements Listener {


    public static String prefix = ChatColor.GRAY + "[Guest] ";
    public static Main instance;
    public static bapiManager api = (bapiManager) Bukkit.getServer().getPluginManager().getPlugin("AutoBroadcastAPI");
    public String on = ChatColor.GREEN + "FFA Enabled!";
    public String off = ChatColor.RED + "FFA Disabled!";
    public String broadc = ChatColor.AQUA + "AutoBroadcast >>";

    public static Main getInstance() {
        return instance;
    }

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);


    }

    @Override

    public void onEnable() {
        getServer().getConsoleSender().sendMessage(on);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerKillEvent(), this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
        getServer().getPluginManager().registerEvents(new ArmourWear(), this);
        getServer().getPluginManager().registerEvents(new KillstreakEvent(), this);
        getServer().getPluginManager().registerEvents(new StatsData(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new KitItems(), this);
        getServer().getPluginManager().registerEvents(new antiBreak(), this);
        getServer().getPluginManager().registerEvents(new Scoreb(), this);
        getServer().getPluginManager().registerEvents(new addStats(), this);
        getServer().getPluginManager().registerEvents(new cancelMob(), this);
        getCommand("kits").setExecutor(new GuiCommand());
        getCommand("stats").setExecutor(new Stats());
        getCommand("resetstats").setExecutor(new Resetstats());
        getCommand("perks").setExecutor(new perkGUI());
        getCommand("addstats").setExecutor(new addStats());
        loadConfig();
        guestNameRunnable();

        saveConfig();
        instance = this;


    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(off);
        instance = null;
        saveConfig();
    }

    public void loadConfig() {
        FileConfiguration cfg = getConfig();
        cfg.options().copyDefaults(true);
        cfg.options().header("Player stats have been registered succesfully");
        saveConfig();
    }

    //TODO Change the API to allow Arrays of strings for the use of Broadcasts.
    public void autoBroadcast() {
        final String[] messages = {
                color(broadc + " &3Check out the developers twitter \"@Rewiind\" "),
                color(broadc + " &3Use /kits to chose a kit and /perk to buy perks!"),
                color(broadc + " &3You're playing on Rewind's Dev Server! ")


        };
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Bukkit.broadcastMessage(Arrays.asList(messages).get(new Random().nextInt(messages.length)));
            }
        }, 0, 5000);
    }

    public void guestNameRunnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!p.hasPlayedBefore()) {
                        p.setDisplayName(prefix + p.getDisplayName());
                        p.setPlayerListName(prefix + p.getDisplayName());
                        p.setCustomNameVisible(true);
                    } else {
                        p.setDisplayName(p.getDisplayName());
                        p.setPlayerListName(p.getPlayerListName());

                    }
                }


            }
        }.runTaskTimerAsynchronously(this, 0, 10);
    }


}
