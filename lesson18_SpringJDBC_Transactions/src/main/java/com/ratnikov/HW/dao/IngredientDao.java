package com.ratnikov.HW.dao;

import com.ratnikov.HW.model.Ingredient;
import com.ratnikov.HW.model.Recipe;

import java.util.List;

public interface IngredientDao {
    Ingredient createSimpleIngredient(Ingredient ingredient);

    void createIngredient(Ingredient ingredient);

    void createIngredients(Ingredient... ingredients);

    void showIngredients();

    List<Ingredient> getIngredients();

    void errorSelect();

    void updateKolvo(Ingredient ingredient, String kolvo);

    void manualTransactionUpdateKolvo(List<Ingredient> ingredients);

    void templateTransactionUpdateKolvo(List<Ingredient> ingredients);

    void annotationUpdateKolvo(List<Ingredient> ingredients);
}
