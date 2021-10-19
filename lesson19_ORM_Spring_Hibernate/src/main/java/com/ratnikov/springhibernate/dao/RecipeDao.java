package com.ratnikov.springhibernate.dao;

import com.ratnikov.springhibernate.model.Recipe;

import java.util.List;

public interface RecipeDao {
    List<Recipe> findAllRecipe();

    List<Recipe> findRecipe(String name);

    void deleteRecipe(int id);
}
