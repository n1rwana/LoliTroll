# <img align="right" src="https://sun9-87.userapi.com/impg/IyBxd-cBUxfrcpcUQfkyY4Uzhc5YIsjEF4BPfg/zMsPVB0ycVk.jpg?size=512x512&quality=95&sign=7a72ae6742cf8194deabe6eeb412c6ad&type=album" alt="LoliCraft" title="LoliCraft" width="15%">

# LoliTroll
 This is a plugin for Minecraft servers on the Spigot core. Adds commands for trolling players.

# Installation  
  You can install this plugin on your own server and use it. 
  >You will need a server running on the **Spigot** kernel version **1.12.2**. The plugin was developed and tested on this version. 
  
  To install the plugin, follow these steps:
  1. Go to the root directory of your server
  2. Go to the **plugins** folder *(if it doesn't exist, you need to create it)*.
  3. Upload the **LoliTroll.jar** from the repository to the **plugins** folder.
  4. Restart the server.
  
# Commands
  - /troll-help — displays help about plugin commands in the chat.
  - /troll-dirt [nick] — fills the inventory of the player specified in the [nick] argument with ground.
  - /troll-freeze [nick] — stops the player specified in the [nick] argument and forbids him to move (to cancel, the player must re-enter the server).
  - /troll-ban [nick] — the player specified in the [nickname] argument kicks with the message "You have been banned from this server!"
  - /troll-op [nick] — the player receives a message that looks like he was given *op*erator permissions.
  - /troll-deop [nick] — the player receives a message that looks as if his *op*erator rights have been removed.
  - /troll-hacks [nick] — the player specified in the [nickname] argument kicks with the message "You have been kicked by anti-cheat. Turn off your hacks!"
  - /troll-burn [nick] — sets fire to the player specified in the [nick] argument.
  - /troll-pumpkin [nick] — puts a pumpkin on the head of the player specified in the [nick] argument
 
# Permissions
  - lolitroll.ban — Allows */troll-ban* command
  - lolitroll.burn — Allows */troll-burn* command
  - lolitroll.deop — Allows */troll-deop* command
  - lolitroll.dirt — Allows */troll-dirt* command
  - lolitroll.freeze — Allows */troll-freeze* command
  - lolitroll.hacks — Allows */troll-hacks* command
  - lolitroll.op — Allows */troll-op* command
  - lolitroll.pumpkin — Allows */troll-pumpkin* command
  - lolitroll.inviolability — complete invulnerability from *all* troll-commands.