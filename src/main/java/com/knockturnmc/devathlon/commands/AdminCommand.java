package com.knockturnmc.devathlon.commands;

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

    public AdminCommand (Permissions perms, Prefix prefix) {
        this.perms = perms;
        this.prefix = prefix;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /**if (!sender.hasPermission(perms.getADMIN_PERMISSION())) {
            sender.sendMessage(prefix.getPREFIX() + ChatColor.RED + "Yeh.... Don't even bother boi! Next time you're getting smited!");
            return true;
        }**/

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players");
            return true;
        }

        Player player = (Player) sender;
        ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = key.getItemMeta();

        ArrayList<String> Lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.WHITE +  "Blank Portkey");
        Lore.add("Portkey");
        Lore.add("Empty");
        meta.setLore(Lore);

        key.setItemMeta(meta);
        player.getInventory().addItem(key);
        return true;
    }
}
