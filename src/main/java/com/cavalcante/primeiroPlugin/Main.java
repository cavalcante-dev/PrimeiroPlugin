package com.cavalcante.primeiroPlugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(this, this);
        System.out.println("Irra, primeiro plugin!");
        getCommand("heal").setExecutor(new HealCommands());
        getCommand("teste").setExecutor(new TesteCommand(this));
        getCommand("consoleHello").setExecutor(new ConsoleCommand());

    }

    public void onPlayerEggThrow(PlayerEggThrowEvent e) {

        e.getPlayer().sendMessage("Stop wasting food! Go do a cake instead.");
        e.setHatchingType(EntityType.WARDEN);
        e.setHatching(true);

    }

}
