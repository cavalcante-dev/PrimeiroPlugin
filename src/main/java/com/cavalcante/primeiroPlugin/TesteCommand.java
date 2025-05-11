package com.cavalcante.primeiroPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TesteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length == 1) {
            if (strings[0].equalsIgnoreCase("Hello")) {
                ((Player) commandSender).sendMessage("Hello, buddy");
            }
        }

        return false;
    }
}
