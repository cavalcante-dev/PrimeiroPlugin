package com.cavalcante.primeiroPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TesteCommand implements CommandExecutor {

    private Main main;

    public TesteCommand(Main main) { this.main = main; }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            player.sendMessage(main.getConfig().getString("Word"));
            player.sendMessage(main.getConfig().getString("Number") + "");
            if (main.getConfig().getBoolean("Boolean")) {
                player.sendMessage("This feature is enabled!");
            }
        
        }

        return false;
    }
}
