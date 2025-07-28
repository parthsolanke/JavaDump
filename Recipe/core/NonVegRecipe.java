package core;

import java.util.Set;

public class NonVegRecipe extends Recipe {

    public NonVegRecipe(String name, String prepTime, Set<String> ingredients, Set<String> tags) {
        super(RecipeType.NON_VEG, name, prepTime, ingredients, tags);
    }

}