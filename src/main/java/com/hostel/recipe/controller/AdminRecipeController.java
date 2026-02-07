package com.hostel.recipe.controller;

import com.hostel.recipe.dto.RecipeResponseDTO;
import com.hostel.recipe.service.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/recipes")
public class AdminRecipeController {

    private final RecipeService recipeService;

    public AdminRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PutMapping("/{id}/reject")
    public RecipeResponseDTO rejectRecipe(@PathVariable Long id) {
        return recipeService.rejectRecipe(id);
    }
}
