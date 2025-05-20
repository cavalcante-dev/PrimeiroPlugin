package com.cavalcante.primeiroPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            if (player.hasPermission("permission.use")) {
                player.sendMessage(ChatColor.BLUE + "Você pode fazer isso zz!");
            } else {
                player.sendMessage(ChatColor.RED + "Você não pode fazer isso não.");
            }

        }

        return false;
    }
}
