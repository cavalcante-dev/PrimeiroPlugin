package com.cavalcante.primeiroPlugin;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.MessageFormat;
import java.util.Objects;

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

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        e.getPlayer().sendTitle(
                ChatColor.GREEN + "Bem Vindo!",
                ChatColor.YELLOW + "Primeiro Plugin em Teste.",
                20,
                100,
                20
                );

        e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy("CHAMA UM MEDICO", net.md_5.bungee.api.ChatColor.BLUE));

        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        helmetMeta.setColor(Color.RED);
        helmet.setItemMeta(helmetMeta);

        e.getPlayer().getInventory().addItem(helmet);
        e.getPlayer().sendMessage("Bem vindo! Toma um chápeu.");

        ItemStack tunic = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta tunicMeta = (LeatherArmorMeta) tunic.getItemMeta();
        tunicMeta.setColor(org.bukkit.Color.fromRGB(255, 51, 0));
        tunic.setItemMeta(tunicMeta);

        e.getPlayer().getInventory().addItem(tunic);
        e.getPlayer().sendMessage("Uma blusinha também pra não passar frio");

    }

    @EventHandler
    public void onCreeperSpawn(CreatureSpawnEvent e) {

        if (e.getEntityType() == EntityType.ENDER_DRAGON) {
            e.setCancelled(true);
            System.out.println("Creeper.... ow man");
            Objects.requireNonNull(Bukkit.getWorld("World")).spawnEntity(e.getLocation(), EntityType.COW);
        }

    }

    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent e) {

        e.getPlayer().sendMessage("Stop wasting food! Go do a cake instead.");
        e.setHatchingType(EntityType.WARDEN);
        e.setHatching(true);

    }

}
