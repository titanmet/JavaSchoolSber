package com.ratnikov.HW.dao;

import com.ratnikov.HW.model.Ingredient;
import com.ratnikov.HW.model.Recipe;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class IngredientDaoImpl implements IngredientDao {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcOperations parameterJdbcOperations;
    private SimpleJdbcInsertOperations insertOperations;
    private RowMapper<Ingredient> ingredientRowMapper;

    public IngredientDaoImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.parameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
        this.insertOperations = new SimpleJdbcInsert(dataSource)
                .withTableName("Ingredient")
                .usingGeneratedKeyColumns("id");
        this.ingredientRowMapper = (resultSet, i) -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setRecipe_id(resultSet.getInt(1));
            ingredient.setName(resultSet.getString(2));
            ingredient.setKolvo(resultSet.getString(3));
            int recipeId = resultSet.getInt(4);

            if (recipeId != 0) {
                Recipe recipe = new Recipe(resultSet.getString(2));
                recipe.setId(recipeId);
                ingredient.setRecipe(recipe);
            }
            return ingredient;
        };
    }

    @Override
    public void createIngredient(Ingredient ingredient) {
        parameterJdbcOperations.update("insert into Ingredient (name, kolvo) values (:name, :kolvo)",
                new BeanPropertySqlParameterSource(ingredient));
    }

    @Override
    public void createIngredients(Ingredient... ingredients) {
        jdbcTemplate.batchUpdate("insert into Ingredient (name, kolvo) values (?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, ingredients[i].getName());
                preparedStatement.setString(2, ingredients[i].getKolvo());
            }

            @Override
            public int getBatchSize() {
                return ingredients.length;
            }
        });
    }

    @Override
    public void showIngredients() {
        jdbcTemplate.queryForList("select * from ingredient order by id").forEach(System.out::println);
    }

    @Override
    public List<Ingredient> getIngredients() {
        return parameterJdbcOperations.query("select * from ingredient", this.ingredientRowMapper);
    }
}
