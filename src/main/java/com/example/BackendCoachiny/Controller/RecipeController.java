package com.example.BackendCoachiny.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackendCoachiny.Model.Recipe;
import com.example.BackendCoachiny.Services.RecipeService;

@RestController
@RequestMapping("/ebook/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.saveRecipe(recipe));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/byPeriod")
    public ResponseEntity<List<Recipe>> getRecipesByPeriod(@RequestParam String period) {
        List<Recipe> recipes = recipeService.getRecipesByPeriod(period);
        if (recipes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recipes);
    }
}