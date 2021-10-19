package com.ratnikov.springhibernate.repository;

import com.ratnikov.springhibernate.model.Ingredient;
import com.ratnikov.springhibernate.model.Recipe;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    List<Ingredient> findByRecipe(Recipe recipe, Sort sort);
}
