package me.r.Minigame.Events;

import de.Herbystar.TTA.TTA_Methods;
import me.r.Minigame.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class KillstreakEvent implements Listener {


    public static void randomPotion(Player player) {
        Random rand = new Random();
        int chance = rand.nextInt(3);
        if (chance == 0) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 2));
        } else if (chance == 1) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 2));
        } else if (chance == 2) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 2));
        }


    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = (Player) e.getEntity().getKiller();
        int level = p.getLevel();
        if (p.getLevel() == 5 || p.getLevel() == 10 || p.getLevel() == 15 || p.getLevel() == 20 || p.getLevel() == 25 ||
                p.getLevel() == 30 || p.getLevel() == 35 || p.getLevel() == 40 || p.getLevel() == 45 || p.getLevel() == 50) {
            int killsstreakCoins = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".KillstreakCoins");
            Main.getInstance().getConfig().set("Stats." + p.getName() + ".KillstreakCoins", killsstreakCoins + 1);
            TTA_Methods.sendActionBar(p, Main.color("&e +1 KillstreakCoins! "), 55);
            //TTA_Methods.sendActionBar(p, Main.color("" + this.getRandom(1,2)  +"&e KillstreakCoins! "), 55); //Random value betweens 1 and 2 if they have the perk .contains etc.


            Bukkit.broadcastMessage(Main.color("&3-------------------------------------------"));

            Bukkit.broadcastMessage(p.getDisplayName() + Main.color(" &3&lIs on a Killstreak of ") + p.getLevel() + "!");
            Bukkit.broadcastMessage(Main.color("&3-------------------------------------------"));
            if (!InvClickEvent.lifeSaver.contains(p.getName())) {
                return;
            } else if (getHealthScale(p) <= 10) {//Or p.getHealth <= 10.0
                randomPotion(p);
            }


            for (Player online : Bukkit.getOnlinePlayers()) {
                online.playSound(online.getLocation(), Sound.BLAZE_DEATH, 1, 1);


            }


        }


    }

    private double getHealthScale(Player p) {
        return p.getHealth();


    }


}
