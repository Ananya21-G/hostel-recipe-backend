package com.hostel.recipe.repository;

import com.hostel.recipe.entity.Recipe;
import com.hostel.recipe.entity.RecipeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByStatus(RecipeStatus status);
}
