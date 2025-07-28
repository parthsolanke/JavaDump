package core;

import java.util.Set;

public class VegRecipe extends Recipe {

    public VegRecipe(String name, String prepTime, Set<String> ingredients, Set<String> tags) {
        super(RecipeType.VEG, name, prepTime, ingredients, tags);
    }
    
}