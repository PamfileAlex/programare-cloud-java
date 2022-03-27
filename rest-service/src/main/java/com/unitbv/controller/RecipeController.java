package com.unitbv.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitbv.request.CreateRecipeRequest;
import com.unitbv.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final ObjectMapper objectMapper;
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(ObjectMapper objectMapper, RecipeService recipeService) {
        this.objectMapper = objectMapper;
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CreateRecipeRequest>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PostMapping("/new")
    public ResponseEntity<String> saveRecipe(@RequestBody CreateRecipeRequest recipe) {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(recipeService.saveRecipe(recipe)));
        } catch (RuntimeException | JsonProcessingException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
