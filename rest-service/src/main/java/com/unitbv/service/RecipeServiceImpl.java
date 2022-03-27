package com.unitbv.service;

import com.unitbv.datasource.MyPantry;
import com.unitbv.request.CreateRecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RestTemplate restTemplate;
    private final MyPantry myPantry;

    @Autowired
    public RecipeServiceImpl(RestTemplate restTemplate, MyPantry myPantry) {
        this.restTemplate = restTemplate;
        this.myPantry = myPantry;
    }

    @Override
    public List<CreateRecipeRequest> getAllRecipes() {
        ResponseEntity<CreateRecipeRequest[]> response
                = restTemplate.getForEntity(
                "http://localhost:8081/api/recipe",
                CreateRecipeRequest[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public CreateRecipeRequest saveRecipe(CreateRecipeRequest recipe) {
        ResponseEntity<CreateRecipeRequest> response
                = restTemplate.postForEntity(
                "http://localhost:8081/api/recipe",
                recipe,
                CreateRecipeRequest.class);
        myPantry.saveAllIngredients(recipe.getIngredients());
        return response.getBody();
    }
}
