package com.hostel.recipe.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RecipeSubmitRequestDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String ingredients;

    @NotBlank
    private String steps;

    @NotNull
    @Max(15)
    private Integer cooktime;
}
