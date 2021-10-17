package com.ratnikov.HW.dao;

import com.ratnikov.HW.model.Ingredient;
import com.ratnikov.HW.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Service
public class RecipeDaoImpl implements RecipeDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsertOperations insertOperations;
    private NamedParameterJdbcOperations parameterJdbcOperations;
    private PlatformTransactionManager transactionManager;
    private TransactionTemplate transactionTemplate;

    public RecipeDaoImpl(DataSource dataSource, PlatformTransactionManager transactionManager,
                         TransactionTemplate transactionTemplate, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insertOperations = new SimpleJdbcInsert(dataSource)
                .withTableName("Recipe")
                .usingGeneratedKeyColumns("id");
        this.transactionManager = transactionManager;
        this.transactionTemplate = transactionTemplate;
    }

    public RecipeDaoImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.parameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
        this.insertOperations = new SimpleJdbcInsert(dataSource)
                .withTableName("Recipe")
                .usingGeneratedKeyColumns("id");
    }

    @PostConstruct
    public void init() {
        Recipe soup = new Recipe("Борщ");
        soup.addIngredient(new Ingredient("Мука", "100 грамм"));
        soup.addIngredient(new Ingredient("Яйцо", "5 штук"));
        createRecipe(soup);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        Integer returnKey = (Integer) insertOperations.executeAndReturnKey(new BeanPropertySqlParameterSource(recipe));
        recipe.getIngredients().forEach(p -> p.setRecipe_id(returnKey));
        parameterJdbcOperations.batchUpdate("insert into Ingredient (name, kolvo, recipe_id) values (:name, :kolvo, :recipe_id)",
                SqlParameterSourceUtils.createBatch(recipe.getIngredients()));
        return recipe;
    }

    @Override
    public List<Recipe> findRecipe(String name) {
        List<Recipe> recipes = parameterJdbcOperations.query("select id, name from recipe where name like :name",
                new MapSqlParameterSource("name", "%" + name + "%"),
                (resultSet, i) -> new Recipe(resultSet.getInt("ID"), resultSet.getString("NAME")));
        if (recipes.isEmpty()) {
            throw new IllegalArgumentException("Рецептов нет !");
        }
        recipes.forEach(recipe -> {
            List<Ingredient> ingredients = parameterJdbcOperations.query("select id, name, kolvo, recipe_id from ingredient where recipe_id = :id",
                    new MapSqlParameterSource("id", recipe.getId()),
                    (resultSet, i) -> new Ingredient(resultSet.getString("name"),
                            resultSet.getString("kolvo"),
                            resultSet.getInt("recipe_id")));
            recipe.setIngredients(ingredients);
        });
        return recipes;
    }

    @Override
    public void showRecipes() {
        jdbcTemplate.queryForList("select * from recipe").forEach(System.out::println);
    }

    @Override
    public void deleteRecipe(int id) {
        jdbcTemplate.update("delete from recipe where id = ?", id);
    }
}
