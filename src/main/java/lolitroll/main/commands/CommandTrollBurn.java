/*
 *  Copyright (c) 2021 LoliCraft
 *  Unauthorized copying, decompilation, engineering analysis, public display, renting are strictly prohibited.
 */

package lolitroll.main.commands;

import lolitroll.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTrollBurn implements CommandExecutor {

    private Main plugin;
    public CommandTrollBurn (Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("troll-burn")) {
                if (sender.hasPermission("lolitroll.burn")) {
                    if (args.length >= 1) {
                        String target_nickname = args[0];
                        Player target = Bukkit.getPlayerExact(target_nickname);

                        if (target == null) {
                            if (!(target.hasPermission("lolitroll.inviolability"))) {
                                sender.sendMessage(plugin.getConfig().getString("messages.commands.player_not_found").replace("&", "§")); // Send message about it
                                return true;
                            } else {
                                sender.sendMessage(plugin.getConfig().getString("messages.commands.inviolability").replace("&", "§"));
                            }
                        } else {
                            if (target != sender) {
                                target.setFireTicks(20);

                                target.sendMessage(plugin.getConfig().getString("messages.commands.burntroll.target").replace("&", "§"));
                                sender.sendMessage(plugin.getConfig().getString("messages.commands.burtroll.troll").replace("&", "§"));
                            } else {
                                sender.sendMessage(plugin.getConfig().getString("messages.commands.cant_troll_youself").replace("&", "§"));
                            }
                        }

                        return true;
                    } else {
                        sender.sendMessage(plugin.getConfig().getString("messages.commands.burntroll.usage").replace("&", "§"));
                        return true;
                    }
                } else {
                    sender.sendMessage(plugin.getConfig().getString("messages.commands.permission_error").replace("&", "§"));
                }
                return true;
        }
        return true;
    }
}
