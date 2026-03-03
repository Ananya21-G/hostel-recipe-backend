package com.hostel.recipe.exception;

public class InvalidRecipeStatusException extends RuntimeException {
    public InvalidRecipeStatusException(String message) {
        super(message);
    }
}