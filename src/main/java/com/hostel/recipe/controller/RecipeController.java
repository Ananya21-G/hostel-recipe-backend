package com.hostel.recipe.controller;

import com.hostel.recipe.entity.Recipe;
import com.hostel.recipe.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class AdminRecipeController {
    private final RecipeService recipeService;

    public AdminRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/submit")
    public Recipe submitRecipe(@RequestBody Recipe recipe) {
        return recipeService.submitRecipe(recipe);
    }
    @GetMapping
    public List<Recipe> getAllApprovedRecipe() {
        return recipeService.getApprovedRecipe();
    }
    @PutMapping("/{id}/reject")
    public Recipe rejectRecipe(@PathVariable Long id) {
        return recipeService.rejectRecipe(id);
    }
}
