package com.ratnikov.HW;

import com.ratnikov.HW.config.JdbcTemplateConfig;
import com.ratnikov.HW.dao.RecipeDao;
import com.ratnikov.HW.model.Ingredient;
import com.ratnikov.HW.model.Recipe;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class MainSpring {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        RecipeDao beanRecipe = context.getBean(RecipeDao.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Введите команду - (list | find | add | delete | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }
            String param = null;
            if (params.length > 1) {
                param = params[1].intern();
            }
            switch (params[0]) {
                case "list":
                    beanRecipe.showRecipes();
                    break;
                case "find":
                    List<Recipe> recipes = beanRecipe.findRecipe("Борщ");
                    recipes.forEach(recipe -> System.out.println(recipe.toString()));
                    break;
                case "add":
                    Recipe soup1 = new Recipe("Солянка");
                    soup1.addIngredient(new Ingredient("Колбаса", "500 грамм"));
                    soup1.addIngredient(new Ingredient("Яйцо", "5 штук"));
                    beanRecipe.createRecipe(soup1);
                    break;
                case "delete":
                    beanRecipe.deleteRecipe(1);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }
}
