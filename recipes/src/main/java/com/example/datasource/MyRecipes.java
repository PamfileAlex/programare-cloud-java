package com.example.datasource;

import com.example.model.Ingredient;
import com.example.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyRecipes {
    private final List<Recipe> recipes;

    public MyRecipes() {
        recipes = new ArrayList<>();
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public Optional<Recipe> findRecipeByName(String name) {
        return recipes.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public Recipe saveIngredient(Recipe recipe) {
        if (recipe.getName() == null || recipe.getName().isEmpty()) {
            throw new RuntimeException("Recipe name cannot be empty!");
        }

        for (Ingredient ingredient : recipe.getIngredients()) {
            if (ingredient.getName() == null || ingredient.getName().isEmpty()) {
                throw new RuntimeException("Ingredient name cannot be empty!");
            }
        }

        findRecipeByName(recipe.getName()).ifPresent(i -> {
            throw new RuntimeException("Recipe with name " + i.getName() + " already exists!");
        });
        this.recipes.add(recipe);

        return recipe;
    }
}
