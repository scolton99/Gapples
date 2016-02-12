package tech.spencercolton.gapples;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Spencer Colton
 */
public class Gapples extends JavaPlugin {

    public static boolean craftingAllowed = true;
    public static List<Recipe> recipes = new ArrayList<>();

    @Override
    public void onEnable() {
        addRecipes();
    }

    @Override
    public void onDisable() {

    }

    private static void addRecipes() {
        ItemStack i = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);

        for(PotionType pt : PotionType.values()) {
            ItemStack potion = new Potion(pt).toItemStack(1);

            ShapelessRecipe sr = new ShapelessRecipe(i);
            sr.addIngredient(1, potion.getData());

            sr.addIngredient(1, i.getData());

            recipes.add(sr);
        }

        recipes.stream().forEach(Bukkit::addRecipe);
    }

}
