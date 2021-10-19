package com.ratnikov.springhibernate.repository;

import com.ratnikov.springhibernate.model.Recipe;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findByNameLike(String name);

    List<Recipe> findAll();

    List<Recipe> findAll(Sort sort);

    long count();

    @Query("delete from Recipe r where r.id=:id")
    void deleteRecipe(@Param("id") Integer id);
}
