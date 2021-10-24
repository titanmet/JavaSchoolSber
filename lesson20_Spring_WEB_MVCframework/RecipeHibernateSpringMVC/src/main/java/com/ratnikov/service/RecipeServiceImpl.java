package com.ratnikov.service;

import com.ratnikov.exeption.ResourceNotFoundException;
import com.ratnikov.model.Recipe;
import com.ratnikov.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(@Qualifier("recipeRepository") RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public List <Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    @Transactional
    public Recipe getRecipe(Long id) throws ResourceNotFoundException {
        return recipeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
