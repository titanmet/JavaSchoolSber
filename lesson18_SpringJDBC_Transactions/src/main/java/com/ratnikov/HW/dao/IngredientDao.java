package com.ratnikov.HW.dao;

import com.ratnikov.HW.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    void createIngredient(Ingredient ingredient);

    void createIngredients(Ingredient... ingredients);

    void showIngredients();

    List<Ingredient> getIngredients();
}
