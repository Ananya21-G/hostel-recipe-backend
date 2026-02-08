package com.hostel.recipe.dto;

import com.hostel.recipe.entity.RecipeStatus;
import lombok.Data;

@Data
public class AdminRecipeReviewDTO {
        private Long recipeId;
        private RecipeStatus decision; // APPROVED or REJECTED

    }


