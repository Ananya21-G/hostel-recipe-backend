package com.hostel.recipe.service;

import com.hostel.recipe.entity.Recipe;
import com.hostel.recipe.entity.RecipeStatus;
import com.hostel.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe submitRecipe(Recipe recipe) {
        recipe.setStatus(RecipeStatus.PENDING);
        return recipeRepository.save(recipe);
    }
    public List<Recipe> getApprovedRecipe() {
        return recipeRepository.findByStatus(RecipeStatus.APPROVED);
    }
    public Recipe rejectRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        if (recipe.getStatus() != RecipeStatus.PENDING) {
            throw new RuntimeException("Only pending recipes can be rejected");
        }

        recipe.setStatus(RecipeStatus.REJECTED);
        return recipeRepository.save(recipe);
    }

}
