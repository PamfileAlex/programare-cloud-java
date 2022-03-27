package com.unitbv.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitbv.model.Ingredient;
import com.unitbv.service.PantryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pantry")
public class PantryController {

    private final PantryService pantryService;
    private final ObjectMapper objectMapper;

    @Autowired
    public PantryController(PantryService pantryService, ObjectMapper objectMapper) {
        this.pantryService = pantryService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(pantryService.getAllIngredients());
    }

    @PostMapping
    public ResponseEntity<String> saveIngredient(@RequestBody Ingredient ingredient) {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(pantryService.saveIngredient(ingredient)));
        } catch (RuntimeException | JsonProcessingException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/ingredient")
    public ResponseEntity<String> updateIngredient(@RequestBody Ingredient ingredient) {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(pantryService.updateIngredient(ingredient)));
        } catch (RuntimeException | JsonProcessingException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/ingredient/{name}")
    public ResponseEntity<String> deleteIngredient(@PathVariable String name) {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(pantryService.deleteIngredient(name)));
        } catch (RuntimeException | JsonProcessingException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
