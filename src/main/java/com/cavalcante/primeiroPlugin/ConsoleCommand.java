package com.cavalcante.primeiroPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConsoleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            ((Player) commandSender).sendMessage("No, this is console only!");
        } else {
            System.out.println("Hello, you have messaged the console!");
        }

        return false;
    }
}
