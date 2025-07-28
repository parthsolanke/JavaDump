import core.*;

import java.util.*;

public class RecipeManager {
    public static void main(String[] args) {
        Set<String> ingredients1 = new HashSet<>(Arrays.asList("carrot", "potato", "peas"));
        Set<String> tags1 = new HashSet<>(Arrays.asList("quick", "vegan"));

        Set<String> ingredients2 = new HashSet<>(Arrays.asList("chicken", "onion", "garlic"));
        Set<String> tags2 = new HashSet<>(Arrays.asList("spicy", "dinner"));

        Recipe vegRecipe = new VegRecipe("Vegetable Stir Fry", "20 minutes", ingredients1, tags1);
        Recipe nonVegRecipe = new NonVegRecipe("Chicken Curry", "45 minutes", ingredients2, tags2);

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(vegRecipe);
        recipes.add(nonVegRecipe);

        RecipeRecommender recipeRecommender = new RecipeRecommender(new ArrayList<>());
        recipeRecommender.addRecipes(recipes);

        // Search by ingredients
        Set<String> myIngredients = new HashSet<>(Arrays.asList("carrot", "peas", "salt"));
        List<Recipe> recommendedByIngredients = recipeRecommender.recommendRecipes(myIngredients);

        System.out.println("\n--- Recommended Recipes by Ingredients ---");
        for (Recipe recipe : recommendedByIngredients) {
            System.out.println(ReportGenerator.toString(
                recipe.getName(),
                recipe.getType(),
                recipe.getPrepTime(),
                recipe.getIngredients(),
                recipe.getTags(),
                recipe.isHealthy()
            ));
            System.out.println();
        }

        // Search by tags
        Set<String> myTags = new HashSet<>(Arrays.asList("dinner"));
        List<Recipe> recommendedByTags = recipeRecommender.searchRecipe(myTags);

        System.out.println("\n--- Recommended Recipes by Tags ---");
        for (Recipe recipe : recommendedByTags) {
            System.out.println(ReportGenerator.toString(
                recipe.getName(),
                recipe.getType(),
                recipe.getPrepTime(),
                recipe.getIngredients(),
                recipe.getTags(),
                recipe.isHealthy()
            ));
            System.out.println();
        }
    }
}
