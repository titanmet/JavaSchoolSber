package com.ratnikov.controller;

import com.ratnikov.exeption.ResourceNotFoundException;
import com.ratnikov.model.Recipe;
import com.ratnikov.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String listRecipes(Model model) {
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipe", recipes);
        return "list-recipes";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "recipe-form";
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return "redirect:/";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("recipeId") Long id,
                                    Model model) throws ResourceNotFoundException {
        Recipe recipe = recipeService.getRecipe(id);
        model.addAttribute("recipe", recipe);
        return "recipe-form";
    }

    @GetMapping("/delete")
    public String deleteRecipe(@RequestParam("recipeId") Long id) throws ResourceNotFoundException {
        recipeService.deleteRecipe(id);
        return "redirect:/";
    }
}
