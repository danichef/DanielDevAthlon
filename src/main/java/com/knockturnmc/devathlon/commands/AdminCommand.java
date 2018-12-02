package com.knockturnmc.devathlon.commands;

import com.knockturnmc.devathlon.keyfactory.BlankKey;
import com.knockturnmc.devathlon.utils.Permissions;
import com.knockturnmc.devathlon.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AdminCommand implements CommandExecutor {

    private Permissions perms;
    private Prefix prefix;
    private BlankKey bKey;

    public AdminCommand (Permissions perms, Prefix prefix, BlankKey bKey) {
        this.perms = perms;
        this.prefix = prefix;
        this.bKey = bKey;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(perms.getADMIN_PERMISSION())) {
            sender.sendMessage(prefix.getPREFIX() + ChatColor.RED + "Yeh.... Don't even bother boi! Next time you're getting smited!");
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players");
            return true;
        }

        Player player = (Player) sender;
        player.getInventory().addItem(bKey.blankKey());
        return true;
    }
}
