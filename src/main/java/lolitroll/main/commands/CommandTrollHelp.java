/*
 *  Copyright (c) 2021 LoliCraft
 *  Unauthorized copying, decompilation, engineering analysis, public display, renting are strictly prohibited.
 */

package lolitroll.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import lolitroll.main.Main;

public class CommandTrollHelp implements CommandExecutor {

    private Main plugin;
    public CommandTrollHelp (Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("troll-help")) {
            sender.sendMessage(plugin.getConfig().getString("messages.commands.troll_help").replace("&", "§"));
        }
        return true;
    }
}
