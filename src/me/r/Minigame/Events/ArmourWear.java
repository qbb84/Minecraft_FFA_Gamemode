package me.r.Minigame.Events;


import com.codingforcookies.armorequip.ArmorEquipEvent;
import me.r.Minigame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmourWear implements Listener {


    @EventHandler
    public void onWear(ArmorEquipEvent e) {
        Player p = e.getPlayer();
        if (e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) {
            if (e.getNewArmorPiece().getType() == Material.LEATHER_HELMET) {


                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));

                p.setDisplayName(Main.prefix + p.getName() + ChatColor.BLUE + "  [Archer]");
                p.setPlayerListName(Main.prefix + p.getName() + ChatColor.BLUE + "  [Archer]");
                p.setCustomNameVisible(true);


            }
        }
        if (e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.setPlayerListName(Main.prefix + p.getName());
            p.setDisplayName(Main.prefix + p.getName());
            p.setCustomNameVisible(true);
        }


    }


}