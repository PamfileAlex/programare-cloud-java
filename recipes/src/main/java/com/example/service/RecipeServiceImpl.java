package com.example.service;

import com.example.datasource.MyRecipes;
import com.example.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final MyRecipes myRecipes;

    @Autowired
    public RecipeServiceImpl(MyRecipes myRecipes) {
        this.myRecipes = myRecipes;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return myRecipes.getAllRecipes();
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return myRecipes.saveIngredient(recipe);
    }
}
