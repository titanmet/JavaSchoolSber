package com.ratnikov.springhibernate;

import com.ratnikov.springhibernate.dao.RecipeDao;
import com.ratnikov.springhibernate.model.Ingredient;
import com.ratnikov.springhibernate.model.Recipe;
import com.ratnikov.springhibernate.repository.IngredientRepository;
import com.ratnikov.springhibernate.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Consumer;

@SpringBootApplication
public class Lesson19OrmSpringHibernateApplication implements CommandLineRunner {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;


    public static void main(String[] args) {
        SpringApplication.run(Lesson19OrmSpringHibernateApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Recipe sol = new Recipe();
        sol.setName("Солянка");
        Recipe bor = new Recipe();
        bor.setName("Борщ");
        doInTransaction(em -> {
            recipeRepository.save(sol);
            ingredientRepository.save(new Ingredient("Вода", "1 литр", sol));
            ingredientRepository.save(new Ingredient("Мясо", "1 кг", sol));
            ingredientRepository.save(new Ingredient("Колбаса", "1 кг", sol));
            recipeRepository.save(bor);
            ingredientRepository.save(new Ingredient("Вода", "1 литр", bor));
            ingredientRepository.save(new Ingredient("Мясо", "1 кг", bor));
            ingredientRepository.save(new Ingredient("Овощи", "1 набор", bor));
            em.persist(sol);
            em.persist(bor);
        });
    }

    @PreDestroy
    public void destroy() {
        Query delete_from_recipe = entityManager.createQuery("delete from Recipe");
        delete_from_recipe.executeUpdate();
        Query delete_from_ingredient = entityManager.createQuery("delete from Ingredient");
        delete_from_ingredient.executeUpdate();
    }

    private void doInTransaction(Consumer<EntityManager> consumer) {
        transactionTemplate.executeWithoutResult(transactionStatus -> consumer.accept(entityManager));
    }

    @Override
    public void run(String... args) throws Exception {
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
                    List<Recipe> recipes = recipeDao.findAllRecipe();
                    recipes.forEach(recipe -> System.out.println(recipe.toString()));
                    break;
                case "find":
                    List<Recipe> recipesList = recipeDao.findRecipe("Борщ");
                    recipesList.forEach(recipe -> System.out.println(recipe.toString()));
                    break;
                case "add":
                    Recipe soup = new Recipe();
                    soup.setName("Борщ");
                    doInTransaction(em -> {
                        recipeRepository.save(soup);
                        ingredientRepository.save(new Ingredient("Вода", "1 литр", soup));
                        ingredientRepository.save(new Ingredient("Мясо", "1 кг", soup));
                        ingredientRepository.save(new Ingredient("Овощи", "1 набор", soup));
                        List<Recipe> recipesListAdd = recipeDao.findAllRecipe();
                        recipesListAdd.forEach(recipe -> System.out.println(recipe.toString()));
                        em.persist(soup);
                    });
                    break;
                case "delete":
                    recipeDao.deleteRecipe(1);
                    List<Recipe> recipesListD = recipeDao.findAllRecipe();
                    recipesListD.forEach(recipe -> System.out.println(recipe.toString()));
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
