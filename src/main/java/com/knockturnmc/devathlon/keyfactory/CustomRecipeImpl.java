package com.knockturnmc.devathlon.keyfactory;

import com.knockturnmc.devathlon.utils.Permissions;
import com.knockturnmc.devathlon.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

public class CustomRecipeImpl implements CustomRecipe {

    private BlankKey bKey;

    public CustomRecipeImpl (BlankKey bKey) {
        this.bKey = bKey;
    }

    @Override
    public Recipe craftKey() {
        ItemStack craftItem = bKey.blankKey();
        craftItem.setType(Material.TRIPWIRE_HOOK);
        ShapedRecipe recipe = new ShapedRecipe(craftItem);

        recipe.shape("OIO", "IHI", "OIO");
        recipe.setIngredient('I', Material.END_ROD);
        recipe.setIngredient('O', Material.ENDER_PEARL);
        recipe.setIngredient('H', Material.TRIPWIRE_HOOK);

        return recipe;
    }
}
