package me.r.Minigame.Mains;

import me.r.Minigame.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitItems implements Listener {

    public static String aPrefix = Main.color("&3[Archer]");


    private static ItemStack archerFood = new ItemStack(Material.APPLE);


    public static void archerItems(Player p) {


        ItemStack archerHelmet = new ItemStack(Material.LEATHER_HELMET);
        ItemStack archerChestPlate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack archerLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack archerBoots = new ItemStack(Material.LEATHER_BOOTS);
        ItemStack archerSword = new ItemStack(Material.WOOD_SWORD);
        ItemStack archerBow = new ItemStack(Material.BOW);


        ItemMeta aHelmet = archerHelmet.getItemMeta();
        aHelmet.setDisplayName(aPrefix);
        ItemMeta aChestplate = archerChestPlate.getItemMeta();
        aChestplate.setDisplayName(aPrefix);
        ItemMeta aLeggings = archerLeggings.getItemMeta();
        aLeggings.setDisplayName(aPrefix);
        ItemMeta aBoots = archerBoots.getItemMeta();
        aBoots.setDisplayName(aPrefix);
        ItemMeta aSword = archerSword.getItemMeta();
        aSword.setDisplayName(aPrefix);
        ItemMeta aBow = archerBow.getItemMeta();
        aBow.setDisplayName(aPrefix);
        ItemMeta aFood = archerFood.getItemMeta();
        aFood.setDisplayName(aPrefix);

        archerHelmet.setItemMeta(aHelmet);
        archerChestPlate.setItemMeta(aChestplate);
        archerLeggings.setItemMeta(aLeggings);
        archerBoots.setItemMeta(aBoots);
        archerSword.setItemMeta(aSword);
        archerBow.setItemMeta(aBow);
        archerFood.setItemMeta(aFood);


        p.getInventory().addItem(archerChestPlate);
        p.getInventory().addItem(archerLeggings);
        p.getInventory().addItem(archerBoots);
        p.getInventory().addItem(archerSword);
        p.getInventory().addItem(archerBow);
        p.getInventory().addItem(archerFood);
        p.getInventory().setHelmet(archerHelmet);


    }
    //TODO Special kit items.

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        Player p = (Player) e.getPlayer();
        if (e.getItem().getType().equals(Material.APPLE)) {
            if (e.getItem().equals(archerFood)) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 2));


                if (p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {


                    //p.updateInventory();


                } else {


                }


            }


        }


    }
}



