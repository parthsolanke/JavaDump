package core;

import java.util.Set;

public class ReportGenerator {
    public static String toString(String name, RecipeType type, String prepTime, Set<String> ingredients, Set<String> tags, boolean isHealthy) {
        StringBuilder s = new StringBuilder();

        s.append("Recipe: ").append(name).append("\n");
        s.append("Type: ").append(type).append("\n");
        s.append("Preparation Time: ").append(prepTime).append("\n");
        s.append("Ingredients: ").append(ingredients.toString()).append("\n");
        s.append("Tags: ").append(tags.toString()).append("\n");
        s.append("Healthy: ").append(isHealthy ? "Yes" : "No");

        return s.toString();
    }
}
