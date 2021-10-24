package com.ratnikov.recipespringboot.controller;

import com.ratnikov.recipespringboot.dao.RecipeService;
import com.ratnikov.recipespringboot.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    private final RecipeService service;

    @Autowired
    public AppController(RecipeService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Recipe> listRecipes = service.listAll();
        model.addAttribute("listRecipes", listRecipes);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("Recipe") Recipe recipe) {
        service.save(recipe);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_recipe");
        Recipe recipe = service.get(id);
        mav.addObject("recipe", recipe);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}