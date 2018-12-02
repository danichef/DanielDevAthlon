package com.knockturnmc.devathlon.commands;

import com.knockturnmc.devathlon.DevAthlon;
import com.knockturnmc.devathlon.armorstand.ArmorStandManager;
import com.knockturnmc.devathlon.keyfactory.BlankKey;
import com.knockturnmc.devathlon.particles.Particles;
import com.knockturnmc.devathlon.utils.Permissions;
import com.knockturnmc.devathlon.utils.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommand implements CommandExecutor {

    private Permissions perms;
    private Prefix prefix;
    private BlankKey blankKey;

    public AdminCommand (Permissions perms, Prefix prefix) {
        this.perms = perms;
        this.prefix = prefix;
        this.blankKey = blankKey;
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
        player.getInventory().addItem(blankKey.giveBlankKey());
        return true;
    }
}
