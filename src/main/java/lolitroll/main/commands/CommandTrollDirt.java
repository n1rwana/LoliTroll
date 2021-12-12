/*
 *  Copyright (c) 2021 LoliCraft
 *  Unauthorized copying, decompilation, engineering analysis, public display, renting are strictly prohibited.
 */

package lolitroll.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import lolitroll.main.Main;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CommandTrollDirt implements CommandExecutor {

    private Main plugin;
    public CommandTrollDirt (Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("troll-dirt")) {
                if (sender.hasPermission("lolitroll.dirt")) {
                    // We have permission! Let's now check argument(s).
                    if (args.length >= 1) {
                        String target_nickname = args[0]; // Get target's nickname from the command arguments
                        Player target = Bukkit.getPlayerExact(target_nickname); // Get the target Player by nickname

                        if (target == null) { // If player not found
                            sender.sendMessage(plugin.getConfig().getString("messages.commands.player_not_found").replace("&", "§")); // Send message about it
                            return true;
                        } else { // If player found
                            if (target != sender) { // If player don't tries to use troll command on himself
                                if (!(target.hasPermission("lolitroll.inviolability"))) {
                                    PlayerInventory target_inventory = target.getInventory(); // Get player inventory
                                    ItemStack dirt_stack = new ItemStack(Material.DIRT, 1); // Set dirt stack
                                    target_inventory.clear(); // Clear player inventory
                                    int i = 0;
                                    while (i <= 35) {
                                        target_inventory.setItem(i, dirt_stack);
                                        i++;
                                    }
                                    sender.sendMessage(plugin.getConfig().getString("messages.commands.dirttroll.troll").replace("&", "§"));
                                    target.sendMessage(plugin.getConfig().getString("messages.commands.dirttroll.target").replace("&", "§"));
                                } else {
                                    sender.sendMessage(plugin.getConfig().getString("messages.commands.inviolability").replace("&", "§"));
                                }
                            } else { // If player tries to use troll command on himself
                                sender.sendMessage(plugin.getConfig().getString("messages.commands.cant_troll_youself").replace("&", "§"));
                            }
                        }

                        return true;
                    } else {
                        sender.sendMessage(plugin.getConfig().getString("messages.commands.dirttroll.usage").replace("&", "§"));
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
