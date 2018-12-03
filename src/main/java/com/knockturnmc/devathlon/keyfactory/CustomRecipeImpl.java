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

    private BlankKey bKey;

    public CustomRecipeImpl (BlankKey bKey) {
        this.bKey = bKey;
    }

    @Override
    public Recipe craftKey() {
        ItemStack key = bKey.blankKey();
        ShapedRecipe recipe = new ShapedRecipe(key);

        recipe.shape("HEH", "EIE", "HEH");
        recipe.setIngredient('I', Material.EYE_OF_ENDER);
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('H', Material.TRIPWIRE_HOOK);

        return recipe;
    }
}
