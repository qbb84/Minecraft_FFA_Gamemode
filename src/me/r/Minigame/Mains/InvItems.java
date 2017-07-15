package me.r.Minigame.Mains;

import me.r.Minigame.Events.InvClickEvent;
import me.r.Minigame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;


public class InvItems implements Listener {


    private static Plugin plugin = Main.getPlugin(Main.class);


    public static void kitInvetory(Player player) {
        Inventory i = plugin.getServer().createInventory(null, 9, ChatColor.DARK_GREEN + "Kits!");


        ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("'");
        empty.setItemMeta(emptyMeta);

        ItemStack lchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);


        ItemMeta hmeta = lchestplate.getItemMeta();
        hmeta.setDisplayName(ChatColor.BLUE + "Leather Armour!");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Main.color("&5Click to equip"));
        lore.add(ChatColor.GRAY + "Contains: ");
        lore.add(ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + " Leather Helmet");
        lore.add(ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + " Leather Chestplate");
        lore.add(ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + " Leather Leggnings");
        lore.add(ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + " Leather Boots");
        lore.add(ChatColor.GRAY + "Special Ability: ");
        lore.add(ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + " Permanent Speed 3!");
        lore.add(ChatColor.ITALIC + "Note: You need to wearing the full set to gain the ability!");

        hmeta.setLore(lore);

        lchestplate.setItemMeta(hmeta);


        ItemStack goldChestplate = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemMeta fmeta = goldChestplate.getItemMeta();
        fmeta.setDisplayName(ChatColor.YELLOW + "Gold Armour!");
        goldChestplate.setItemMeta(fmeta);


        i.setItem(0, empty);
        i.setItem(1, empty);
        i.setItem(2, empty);
        i.setItem(3, lchestplate);
        i.setItem(4, empty);
        i.setItem(5, goldChestplate);
        i.setItem(6, empty);
        i.setItem(7, empty);
        i.setItem(8, empty);

        player.openInventory(i);
    }

    /////////////////////////////////////////////////////////////////////////////
    public static void perksInvetory(Player player) {
        Inventory i1 = plugin.getServer().createInventory(null, 36, ChatColor.DARK_GREEN + "Perk menu!");


        ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("'");
        empty.setItemMeta(emptyMeta);

        ItemStack lifeSaver1 = new ItemStack(Material.IRON_BLOCK);


        ItemMeta meta = lifeSaver1.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "LifeSaver I!");
        ArrayList<String> lore = new ArrayList<String>();
        if (!InvClickEvent.lifeSaver.contains(player.getName())) {
            lore.add(" ");
            lore.add(Main.color("&6Click to purchase!"));
            lore.add(Main.color(ChatColor.GRAY + "-" + ChatColor.ITALIC + " Cost: 15 Killstreak coins!"));
            lore.add(" ");
        } else {
            lore.add(" ");
            lore.add(Main.color("&aAlready purchased!"));
            lore.add(" ");

        }
        lore.add(ChatColor.GRAY + "Perk includes: ");
        lore.add(" ");
        lore.add(ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + " When your health is low you will get a random potion effect!");
        lore.add(ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + " The potions include, Jump, Speed, Strength.");
        lore.add(" ");
        lore.add(ChatColor.GRAY + "Special Ability: ");
        lore.add(" ");
        lore.add(ChatColor.GRAY + "-" + ChatColor.DARK_AQUA + " A random potion effect when at a low health.");
        lore.add(" ");
        lore.add(ChatColor.ITALIC + "Note: You need to be on a killstreak and be less than 10 health when killing someone!");

        meta.setLore(lore);

        lifeSaver1.setItemMeta(meta);


        ItemStack lifeSaver2 = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta fmeta = lifeSaver2.getItemMeta();
        fmeta.setDisplayName(ChatColor.YELLOW + "LifeSaver II!");
        lifeSaver2.setItemMeta(fmeta);


        i1.setItem(0, empty);
        i1.setItem(1, empty);
        i1.setItem(2, empty);
        i1.setItem(3, lifeSaver1);
        i1.setItem(4, empty);
        i1.setItem(5, lifeSaver2);
        i1.setItem(6, empty);
        i1.setItem(7, empty);
        i1.setItem(8, empty);
        i1.setItem(9, empty);
        i1.setItem(10,empty);
        i1.setItem(11,empty);
        //TODO i1.setItem(12,kamakazee);

        player.openInventory(i1);
    }



}



