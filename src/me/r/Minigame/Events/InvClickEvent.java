package me.r.Minigame.Events;


import de.Herbystar.TTA.TTA_Methods;
import me.r.Minigame.Main;
import me.r.Minigame.Mains.InvItems;
import me.r.Minigame.Mains.KitItems;
import me.r.Minigame.Mains.Scoreb;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


public class InvClickEvent implements Listener {

    public static List<String> lifeSaver = new ArrayList<>();


    @EventHandler
    public void InvenClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        Inventory open = event.getClickedInventory();
        ItemStack item = event.getCurrentItem();


        if (open == null) {
            return;
        }
        if (open.getName().equals(ChatColor.DARK_GREEN + "Kits!")) {

            event.setCancelled(true);

            if (item == null || !item.hasItemMeta()) {
                return;
            }

            if (item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Leather Armour!")) {


                KitItems.archerItems(player);


                player.closeInventory();
                InvItems ci = new InvItems();
                ci.kitInvetory(player);
                player.updateInventory();
            }

        }

    }


    //TODO New event for new GUI. /perks
    @EventHandler
    public void perkInv(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        Inventory open = e.getClickedInventory();
        ItemStack item = e.getCurrentItem();

        if (open == null) {
            return;
        }
        if (open.getName().equals(ChatColor.DARK_GREEN + "Perk menu!")) {

            e.setCancelled(true);

            if (item == null || !item.hasItemMeta()) {
                return;
            }

            if (item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "LifeSaver I!")) {
                int killsstreakCoins = Main.getInstance().getConfig().getInt("Stats." + player.getName() + ".KillstreakCoins");
                if (killsstreakCoins >= 15) {
                    if (!lifeSaver.contains(player.getName())) {
                        lifeSaver.add(player.getName());
                        Main.getInstance().getConfig().set("Stats." + player.getName() + ".KillstreakCoins", killsstreakCoins - 15);
                        player.sendMessage(Main.color("&3-------------------------------------------"));
                        player.sendMessage(Main.color("&eYou have purchased LifeSaver I!"));
                        player.sendMessage(Main.color("&3-------------------------------------------"));
                        TTA_Methods.sendActionBar(player, Main.color("&e LifeSaver I Purchased! -15 KillstreakCoins! "), 90);
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
                        Scoreb.updateScoreb(player);
                        InvItems.perksInvetory(player);


                    }


                } else {
                    if (!lifeSaver.contains(player.getName())) {
                        if (killsstreakCoins < 15) {
                            player.sendMessage(Main.color("&cYou don't have enough Killstreak coins!"));
                        }
                    }

                }
                if (lifeSaver.contains(player.getName())) {
                    player.sendMessage(Main.color("&bYou already have this perk purchased!"));
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                    return;

                }


                player.closeInventory();
                InvItems ci = new InvItems();
                ci.perksInvetory(player);
                player.updateInventory();
            }

        }


    }

}
