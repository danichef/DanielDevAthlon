package com.knockturnmc.devathlon.keyfactory;

import com.knockturnmc.devathlon.utils.Permissions;
import com.knockturnmc.devathlon.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomRecipeImpl implements CustomRecipe {

    @Override
    public Recipe craftKey() {
        ItemStack key = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = key.getItemMeta();
        ArrayList<String> Lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.WHITE +  "Blank Portkey");
        Lore.add("Portkey");
        Lore.add(ChatColor.GOLD + "" + ChatColor.MAGIC + "Empty");
        meta.setLore(Lore);
        key.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(key);

        recipe.shape("OIO", "IHI", "OIO");
        recipe.setIngredient('I', Material.END_ROD);
        recipe.setIngredient('O', Material.ENDER_PEARL);
        recipe.setIngredient('H', Material.TRIPWIRE_HOOK);

        return recipe;
    }
}
