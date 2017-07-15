package me.r.Minigame.Commands;

import me.r.Minigame.Mains.InvItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class perkGUI implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            InvItems.perksInvetory(p);
            return true;
        }
        return false;
    }
}
