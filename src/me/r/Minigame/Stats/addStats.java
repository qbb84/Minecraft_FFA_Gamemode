package me.r.Minigame.Stats;

import me.r.Minigame.Main;
import me.r.Minigame.Mains.Scoreb;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class addStats implements CommandExecutor, Listener {


    private Main plugin = Main.getPlugin(Main.class);


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.color("&4You need to be a player to execute this command!"));
            return true;

        }
        if (!(sender.hasPermission("stats.add"))) {
            sender.sendMessage(Main.color("&4No permission!"));
            return true;

        }
        if (args.length == 0) {
            Player p = (Player) sender;
            //TODO Get the stats from the config.


            Main.getInstance().getConfig().set("Stats." + p.getName() + ".Kills",  args[1]);
            Main.getInstance().getConfig().set("Stats." + p.getName() + ".Deaths",  args[1]);
            Main.getInstance().getConfig().set("Stats." + p.getName() + ".KillstreakCoins",  args[1]);
            p.sendMessage(Main.color("&aYour stats have been edited!") + args[1]);
            Scoreb.updateScoreb(p);
            return true;
        }
        if (args.length == 1) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target != null) {
                Main.getInstance().getConfig().set("Stats." + target.getName() + ".Kills", +15);
                Main.getInstance().getConfig().set("Stats." + target.getName() + ".Deaths", +15);
                Main.getInstance().getConfig().set("Stats." + target.getName() + ".KillstreakCoins", +15);
                sender.sendMessage(Main.color("&4You have added stats to" + target.getName() + "'s Stats!"));
                target.sendMessage(Main.color("&aYour stats have been edited!"));
                Scoreb.updateScoreb(target);
                return true;
            } else {
                sender.sendMessage(Main.color("&cThat player isn't online or hasn't played before!"));
            }


        }
        return false;
    }


}


