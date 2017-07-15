package me.r.Minigame.Stats;

import me.r.Minigame.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Resetstats implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.color("&4You need to be a player to execute this command!"));
            return true;

        }
        if (!(sender.hasPermission("stats.reset"))) {
            sender.sendMessage(Main.color("&4No permission!"));
            return true;

        }
        if (args.length == 0) {
            Player p = (Player) sender;

            Main.getInstance().getConfig().set("Stats." + p.getName() + ".Kills", Integer.valueOf(0));
            Main.getInstance().getConfig().set("Stats." + p.getName() + ".Deaths", Integer.valueOf(0));
            Main.getInstance().getConfig().set("Stats." + p.getName() + ".KillstreakCoins", Integer.valueOf(0));
            p.kickPlayer(Main.color(Main.color("&aYour stats have been reset!")));
            return true;
        }
        if (args.length == 1) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target != null) {
                Main.getInstance().getConfig().set("Stats." + target.getName() + ".Kills", Integer.valueOf(0));
                Main.getInstance().getConfig().set("Stats." + target.getName() + ".Deaths", Integer.valueOf(0));
                Main.getInstance().getConfig().set("Stats." + target.getName() + ".KillstreakCoins", Integer.valueOf(0));
                sender.sendMessage(Main.color("&4You have reset" + target.getName() + "'s Stats!"));
                target.kickPlayer(Main.color("&aYour stats have been reset"));
                return true;
            } else {
                sender.sendMessage(Main.color("&cThat player isn't online or hasn't played before!"));
            }

        }
        return false;
    }


}
