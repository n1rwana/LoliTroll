/*
 *  Copyright (c) 2021 LoliCraft
 *  Unauthorized copying, decompilation, engineering analysis, public display, renting are strictly prohibited.
 */

// This command does not work now and is disabled. Perhaps it will be added in the next version.

package lolitroll.main.commands;

import lolitroll.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CommandTrollFreeze implements CommandExecutor, Listener {
    private Main plugin;
    public CommandTrollFreeze (Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void cancelPlayerMove(PlayerMoveEvent event) {
        Player target = event.getPlayer();
        if (target != null) {
            event.setCancelled(true);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("troll-freeze")) {
                if (sender.hasPermission("lolitroll.freeze")) {
                    if (args.length >= 1) {
                        String target_nickname = args[0];
                        Player target = Bukkit.getPlayerExact(target_nickname);

                        if (target == null) {
                            sender.sendMessage(plugin.getConfig().getString("messages.commands.player_not_found").replace("&", "§")); // Send message about it
                            return true;
                        } else {
                            target.setWalkSpeed(0);
                            target.setFlySpeed(0);
                            target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 250));

                            sender.sendMessage(plugin.getConfig().getString("messages.commands.freezetroll.troll").replace("&", "§"));
                            target.sendMessage(plugin.getConfig().getString("messages.commands.freezetroll.target").replace("&", "§"));
                        }
                    } else {
                        sender.sendMessage(plugin.getConfig().getString("messages.commands.freezetroll.usage").replace("&", "§"));
                    }
                } else {
                    sender.sendMessage(plugin.getConfig().getString("messages.commands.permission_error").replace("&", "§"));
                }
        }

        return true;
    }
}
