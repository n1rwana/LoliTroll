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

public class CommandTrollDeOP implements CommandExecutor {

    private Main plugin;
    public CommandTrollDeOP (Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("troll-deop")) {
                if (sender.hasPermission("lolitroll.deop")) {
                    if (args.length >= 1) {
                        String target_nickname = args[0];
                        Player target = Bukkit.getPlayerExact(target_nickname);

                        if (target == null) {
                            sender.sendMessage(plugin.getConfig().getString("messages.commands.player_not_found").replace("&", "§")); // Send message about it
                            return true;
                        } else {
                            if (target != sender) {
                                if (!(target.hasPermission("lolitroll.inviolability"))) {
                                    String fakeop_msg = "§7§o[Server: " + target_nickname + " больше не оператор]";
                                    String fakeop_troll_msg = "§3§l» §aИгрок получил сообщение§r " + fakeop_msg;
                                    sender.sendMessage(fakeop_troll_msg);
                                    target.sendMessage(fakeop_msg);
                                } else {
                                    sender.sendMessage(plugin.getConfig().getString("messages.commands.inviolability").replace("&", "§"));
                                }
                            } else {
                                sender.sendMessage(plugin.getConfig().getString("messages.commands.cant_troll_youself").replace("&", "§"));
                            }
                        }
                        return true;
                    } else {
                        sender.sendMessage(plugin.getConfig().getString("messages.commands.deoptroll.usage").replace("&", "§"));
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
