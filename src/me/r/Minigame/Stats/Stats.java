package me.r.Minigame.Stats;

import me.r.Minigame.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Stats implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                int kills = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Kills");
                int deaths = Main.getInstance().getConfig().getInt("Stats." + p.getName() + ".Deaths");
                if ((kills == 0) && deaths == 0) {
                    sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                    sender.sendMessage(Main.color("&3Player: &f" + p.getDisplayName()));
                    sender.sendMessage(Main.color("&3Kills: &f0"));
                    sender.sendMessage(Main.color("&3Deaths: &f0"));
                    sender.sendMessage(Main.color("&3Streak: &f" + p.getLevel()));
                    sender.sendMessage(Main.color("&3KDR: &f0"));

                    sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                    sender.sendMessage(" ");
                    return true;

                } else if (deaths == 0) {
                    sender.sendMessage(" ");
                    sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                    sender.sendMessage(Main.color("&3Player: &f " + p.getDisplayName()));
                    sender.sendMessage(Main.color("&3Kills: &f " + kills));
                    sender.sendMessage(Main.color("&3Deaths: &f0 "));
                    sender.sendMessage(Main.color("&3Streak: &f" + p.getLevel()));
                    sender.sendMessage(Main.color("&3KDR: &f ") + kills);
                    sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                    sender.sendMessage(" ");
                    return true;
                } else {
                    double kdr = kills / deaths;
                    String out = String.format("%.1f", Double.valueOf(kdr));
                    sender.sendMessage(" ");
                    sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                    sender.sendMessage(Main.color("&3Player: &f " + p.getDisplayName()));
                    sender.sendMessage(Main.color("&3Kills: &f " + kills));
                    sender.sendMessage(Main.color("&3Deaths: &f " + deaths));
                    sender.sendMessage(Main.color("&3Streak: &f" + p.getLevel()));
                    sender.sendMessage(Main.color("&3KDR: &f ") + out);
                    sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                    sender.sendMessage(" ");
                    return true;

                }

            }

            if (args.length == 1) {

                Player t = Bukkit.getServer().getPlayer(args[0]);
                if (t != null) {

                    int kills = Main.getInstance().getConfig().getInt("Stats." + t.getName() + ".Kills");
                    int deaths = Main.getInstance().getConfig().getInt("Stats." + t.getName() + ".Deaths");


                    if ((kills == 0) && deaths == 0) {
                        sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                        sender.sendMessage(Main.color("&3Player: &f" + t.getDisplayName()));
                        sender.sendMessage(Main.color("&3Kills: &f0"));
                        sender.sendMessage(Main.color("&3Deaths: &f0"));
                        sender.sendMessage(Main.color("&3Streak: &f" + t.getLevel()));
                        sender.sendMessage(Main.color("&3KDR: &f0"));
                        sender.sendMessage(Main.color("&b>>>&5Stats&b<<<"));
                        sender.sendMessage(" ");
                        return true;

                    } else if (deaths == 0) {
                        sender.sendMessage(" ");
                        sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                        sender.sendMessage(Main.color("&3Player: &f " + t.getDisplayName()));
                        sender.sendMessage(Main.color("&3Kills: &f " + kills));
                        sender.sendMessage(Main.color("&3Deaths: &f0 "));
                        sender.sendMessage(Main.color("&3Streak: &f" + t.getLevel()));
                        sender.sendMessage(Main.color("&3KDR: &f ") + kills);
                        sender.sendMessage(Main.color("&b>>>&5Stats&b<<<"));
                        sender.sendMessage(" ");
                        return true;
                    } else {
                        double kdr = kills / deaths;
                        String out = String.format("%.1f", Double.valueOf(kdr));
                        sender.sendMessage(" ");
                        sender.sendMessage(Main.color("&b >>> &5Stats &b<<<"));
                        sender.sendMessage(Main.color("&3Player: &f " + t.getDisplayName()));
                        sender.sendMessage(Main.color("&3Kills: &f " + kills));
                        sender.sendMessage(Main.color("&3Deaths: &f " + deaths));
                        sender.sendMessage(Main.color("&3Streak: &f" + t.getLevel()));
                        sender.sendMessage(Main.color("&3KDR: &f ") + out);
                        sender.sendMessage(Main.color("&b>>>&5Stats&b<<<"));
                        sender.sendMessage(" ");
                        return true;
                    }

                } else {
                    sender.sendMessage(Main.color("&cThat player isn't online or hasn't played before!"));
                }

            }


        } else {
            sender.sendMessage("You need to be a player to use this command!");

        }

        return false;
    }
}
