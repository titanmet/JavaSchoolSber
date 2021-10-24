package com.ratnikov.recipespringboot.repository;

import com.ratnikov.recipespringboot.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
