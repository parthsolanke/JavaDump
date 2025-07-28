package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RecipeRecommender {
    private List<Recipe> recipies = new ArrayList<>();

    public RecipeRecommender(List<Recipe> recipies) {
        this.recipies = recipies;
    }

    public void addRecipes(List<Recipe> recipes) {
        for (Recipe recipe: recipes) {
            this.recipies.add(recipe);
        }
    }
    
    public List<Recipe> recommendRecipes(Set<String> ingredients) {
        List<Recipe> recomendList = new ArrayList<>();
        for(Recipe recipe: this.recipies) {
            if (recipe.matchIngredients(ingredients) >= 50) {
                recomendList.add(recipe);
            }
        }
        return recomendList;
    };

    public List<Recipe> searchRecipe(Set<String> tags) {
        List<Recipe> recomendList = new ArrayList<>();
        for(Recipe recipe: this.recipies) {
            if (recipe.matchTags(tags) >= 50) {
                recomendList.add(recipe);
            }
        }
        return recomendList;
    };

    // public List<Recipe> sortRecipe(){};
}