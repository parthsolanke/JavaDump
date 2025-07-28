package core;

import java.util.HashSet;
import java.util.Set;

enum RecipeType {
    VEG, NON_VEG
}

enum HealthLevel {
    HEALTHY, MODERTE, UNHEALTHY
}

abstract public class Recipe {
    private RecipeType type;
    private String name;
    private String prepTime;
    private Set<String> ingredients = new HashSet<>();
    private Set<String> tags = new HashSet<>();

    public Recipe(RecipeType type, String name, String prepTime, Set<String> ingredients, Set<String> tags) {
        this.type = type;
        this.name = name;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.tags = tags;
    }

    public boolean isHealthy() {
        if (ingredients.contains("carrot")) return true;
        return false;
    }

    public double matchIngredients(Set<String> ingredients) {
        Set<String> common = new HashSet<>(this.ingredients);
        common.retainAll(ingredients);

        int unionSize = this.ingredients.size() + ingredients.size() - common.size();
        return ((double) common.size() / unionSize) * 100;
    }


    public double matchTags(Set<String> tags) {
        Set<String> common = new HashSet<>(this.tags);
        common.retainAll(tags);

        int unionSize = this.tags.size() + tags.size() - common.size();
        return ((double) common.size() / unionSize) * 100;
    }


    // getters and setters
    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}