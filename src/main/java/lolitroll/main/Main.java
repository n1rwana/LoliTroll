/*
 *  Copyright (c) 2021 LoliCraft
 *  Unauthorized copying, decompilation, engineering analysis, public display, renting are strictly prohibited.
 */

// This is the Main class. Here we include the commands and listeners and turn the plugin on.

package lolitroll.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import lolitroll.main.commands.*; // Import all commands from lolitroll.main.commands
import org.bukkit.potion.PotionEffectType;

public final class Main extends JavaPlugin implements Listener {
    Logger log = Logger.getLogger("Minecraft"); // We set a Logger for logs, respectively :D
    String prefix = "[LoliTroll]"; // Plugin prefix. Also for logs.

    @Override
    public void onEnable() { // What happens when the plugin is turning ON.
        // Here we connect all the plugin commands...
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("troll").setExecutor(new CommandTroll(this));
        getCommand("troll-help").setExecutor(new CommandTrollHelp(this));
        getCommand("troll-dirt").setExecutor(new CommandTrollDirt(this));
        getCommand("troll-freeze").setExecutor(new CommandTrollFreeze(this));
        getCommand("troll-ban").setExecutor(new CommandTrollBan(this));
        getCommand("troll-op").setExecutor(new CommandTrollOP(this));
        getCommand("troll-deop").setExecutor(new CommandTrollDeOP(this));
        getCommand("troll-hack").setExecutor(new CommandTrollHacks(this));
        getCommand("troll-burn").setExecutor(new CommandTrollBurn(this));
        getCommand("troll-pumpkin").setExecutor(new CommandTrollPumpkin(this));
        // ..and doing log to the console
        log.info(prefix + " Плагин активирован!");
    }

    @Override
    public void onDisable() { // What happens when the plugin is turning OFF. Only log to the console.
        log.info(prefix + " Плагин выключен!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.removePotionEffect(PotionEffectType.SLOW);
        player.removePotionEffect(PotionEffectType.JUMP);
        player.setWalkSpeed((float) 0.2);
        player.setFlySpeed((float) 0.1);
    }
}
