package com.hostel.recipe.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recipes")
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Recipe() {
        this.createdAt = LocalDateTime.now();
        this.status = RecipeStatus.PENDING;
    }
}
