package me.r.Minigame.Events;

import de.Herbystar.TTA.TTA_Methods;
import me.r.Minigame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class JoinEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        p.setLevel(0);
        giveItem(p);
        EntityDEvent.setRandomLocation(p);
        TTA_Methods.addEntityGlow(p, Color.BLUE);
        //Main.api.autoBroadcast(p.getPlayer(),  "", Bukkit.getWorld("world"), 0, 1000, true);


    }

    public void giveItem(Player p) {

        ItemStack item = new ItemStack(Material.SNOW_BALL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.color("&lA MAGIC SNOWBALL"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.AQUA + "It has a magic effect.");
        lore.add(ChatColor.BOLD + "Uses: 1");
        meta.setLore(lore);
        item.setItemMeta(meta);

        p.getInventory().addItem(item);


    }

    @EventHandler
    public void launcher(PlayerInteractEvent e) {
        Action action = Action.LEFT_CLICK_AIR;
        Player p = e.getPlayer();
        if (action.equals(Action.LEFT_CLICK_AIR)) {
            p.setVelocity(new Vector(0, 20, 0));


            if (p.isSneaking()) {
                if (!p.isOnGround()) {
                    Vector vector = p.getLocation().getDirection().multiply(5);
                    p.setVelocity(vector);

                }


            } else {
                p.sendMessage(ChatColor.RED + "YOU NEED TO SNEEK TO SUICIDE YOURSELF AND EXPLODE ON PEOPLE");
                p.teleport(p.getLocation());

            }


        }

    }


}
