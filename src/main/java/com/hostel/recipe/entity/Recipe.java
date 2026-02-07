package com.hostel.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "recipes")
@Getter
@Setter

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 500)
    private String ingredients;

    @Column(nullable = false, length = 1000)
    private String steps;

    @Column(nullable = false)
    private Integer cookTime;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecipeStatus status;


    public Recipe() {
        this.createdAt = LocalDateTime.now();
        this.status = RecipeStatus.PENDING;
    }
}
