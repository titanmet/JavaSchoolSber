package com.ratnikov.repository;

import com.ratnikov.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("recipeRepository")
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
