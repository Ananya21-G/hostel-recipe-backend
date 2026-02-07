package com.hostel.recipe.controller;

import com.hostel.recipe.dto.RecipeSubmitRequestDTO;
import com.hostel.recipe.dto.RecipeResponseDTO;
import com.hostel.recipe.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/submit")
    public RecipeResponseDTO submitRecipe(
            @Valid @RequestBody RecipeSubmitRequestDTO request) {
        return recipeService.submitRecipe(request);
    }

    @GetMapping
    public List<RecipeResponseDTO> getAllApprovedRecipes() {
        return recipeService.getApprovedRecipes();
    }
}
