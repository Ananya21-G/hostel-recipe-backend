package com.hostel.recipe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RecipeResponseDTO {

    private Long id;
    private String title;
    private String ingredients;
    private String steps;
    private Integer cookTime;
}
