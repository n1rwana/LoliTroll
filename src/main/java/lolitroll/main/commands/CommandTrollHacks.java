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

public class CommandTrollHacks implements CommandExecutor {

    private Main plugin;
    public CommandTrollHacks (Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("troll-hack")) {
                if (sender.hasPermission("lolitroll.hack")) {
                    if (args.length >= 1) {
                        String target_nickname = args[0];
                        Player target = Bukkit.getPlayerExact(target_nickname);

                        if (target == null) {
                            sender.sendMessage(plugin.getConfig().getString("messages.commands.player_not_found").replace("&", "§")); // Send message about it
                            return true;
                        } else {
                            if (target != sender) {
                                if (!(target.hasPermission("lolitroll.inviolability"))) {
                                    target.kickPlayer("You have been kicked by anti-cheat. Turn off your hacks!");
                                    sender.sendMessage(plugin.getConfig().getString("messages.commands.hacktroll.troll").replace("&", "§"));
                                } else {
                                    sender.sendMessage(plugin.getConfig().getString("messages.commands.inviolability").replace("&", "§"));
                                }
                            } else {
                                sender.sendMessage(plugin.getConfig().getString("messages.commands.cant_troll_youself").replace("&", "§"));
                            }
                        }

                        return true;
                    } else {
                        sender.sendMessage(plugin.getConfig().getString("messages.commands.hacktroll.usage").replace("&", "§"));
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
