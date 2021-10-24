package com.ratnikov.recipespringboot.dao;

import com.ratnikov.recipespringboot.model.Recipe;
import com.ratnikov.recipespringboot.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeService {

    private final RecipeRepository repo;

    @Autowired
    public RecipeService(RecipeRepository repo) {
        this.repo = repo;
    }

    public List<Recipe> listAll() {
        return repo.findAll();
    }

    public void save(Recipe recipe) {
        repo.save(recipe);
    }

    public Recipe get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}