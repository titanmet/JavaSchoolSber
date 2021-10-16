package com.ratnikov.HW.dao;

import com.ratnikov.HW.model.Recipe;

import java.util.List;

public interface RecipeDao {
    Recipe createRecipe(Recipe recipe);

    List<Recipe> findRecipe(String name);

    void showRecipes();

    void deleteRecipe(int id);
}
