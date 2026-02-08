package com.hostel.recipe.service;

import com.hostel.recipe.dto.AdminRecipeReviewDTO;
import com.hostel.recipe.dto.RecipeResponseDTO;
import com.hostel.recipe.dto.RecipeSubmitRequestDTO;
import com.hostel.recipe.entity.Recipe;
import com.hostel.recipe.entity.RecipeStatus;
import com.hostel.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public RecipeResponseDTO submitRecipe(RecipeSubmitRequestDTO request) {
        Recipe recipe = mapToEntity(request);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return mapToResponseDTO(savedRecipe);
    }

    public List<RecipeResponseDTO> getApprovedRecipes() {
        return recipeRepository.findByStatus(RecipeStatus.APPROVED)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public RecipeResponseDTO reviewRecipe(AdminRecipeReviewDTO reviewDTO) {

        Recipe recipe = recipeRepository.findById(reviewDTO.getRecipeId())
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        if (recipe.getStatus() != RecipeStatus.PENDING) {
            throw new RuntimeException("Only pending recipes can be reviewed");
        }

        if (reviewDTO.getDecision() == RecipeStatus.PENDING) {
            throw new RuntimeException("Invalid review decision");
        }

        recipe.setStatus(reviewDTO.getDecision());
        Recipe savedRecipe = recipeRepository.save(recipe);

        return mapToResponseDTO(savedRecipe);
    }

    private Recipe mapToEntity(RecipeSubmitRequestDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setTitle(dto.getTitle());
        recipe.setIngredients(dto.getIngredients());
        recipe.setSteps(dto.getSteps());
        recipe.setCookTime(dto.getCookTime());
        recipe.setStatus(RecipeStatus.PENDING);
        return recipe;
    }

    private RecipeResponseDTO mapToResponseDTO(Recipe recipe) {
        RecipeResponseDTO dto = new RecipeResponseDTO();
        dto.setId(recipe.getId());
        dto.setTitle(recipe.getTitle());
        dto.setIngredients(recipe.getIngredients());
        dto.setSteps(recipe.getSteps());
        dto.setCookTime(recipe.getCookTime());
        return dto;
    }
}
