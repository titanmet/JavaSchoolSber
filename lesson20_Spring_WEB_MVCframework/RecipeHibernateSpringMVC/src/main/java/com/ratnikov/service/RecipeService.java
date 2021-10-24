package com.ratnikov.service;

import com.ratnikov.exeption.ResourceNotFoundException;
import com.ratnikov.model.Recipe;

import java.util.List;

public interface RecipeService {
    public List<Recipe> getRecipes();
    public void saveRecipe(Recipe recipe);
    public Recipe getRecipe(Long id) throws ResourceNotFoundException;
    public void deleteRecipe(Long id) throws ResourceNotFoundException;
}
