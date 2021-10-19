package com.ratnikov.springhibernate.dao;

import com.ratnikov.springhibernate.model.Ingredient;
import com.ratnikov.springhibernate.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecipeDaoImpl implements RecipeDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Recipe> findAllRecipe() {
        List<Recipe> recipes = entityManager.createQuery("select r from Recipe r", Recipe.class).getResultList();
        recipes.forEach(recipe -> {
                    List<Ingredient> ingredients = entityManager.createQuery("select i from Ingredient i where i.recipe = :recipe",
                            Ingredient.class).setParameter("recipe", recipe).getResultList();
                    recipe.setIngredients(ingredients);
                }
        );
        return recipes;
    }

    @Override
    @Transactional
    public List<Recipe> findRecipe(String name) {
        List<Recipe> recipes = entityManager.createQuery("select r from Recipe r where r.name like :name", Recipe.class)
                .setParameter("name", "%" + name + "%").getResultList();
        if (recipes.isEmpty()) {
            throw new IllegalArgumentException("Рецептов нет !");
        }
        recipes.forEach(recipe -> {
                    List<Ingredient> ingredients = entityManager.createQuery("select i from Ingredient i where i.recipe = :recipe",
                            Ingredient.class).setParameter("recipe", recipe).getResultList();
                    recipe.setIngredients(ingredients);
                }
        );
        return recipes;
    }

    @Override
    @Transactional
    public void deleteRecipe(int id) {
        Recipe e = entityManager.find(Recipe.class, id);
        for (Ingredient i : e.getIngredients()) {
            if (i.getRecipe().getId() == id) {
                entityManager.remove(i);
            }
            entityManager.remove(e);
        }
    }
}
