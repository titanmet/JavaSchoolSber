package com.ratnikov;

import com.ratnikov.HW.config.JdbcTemplateConfig;
import com.ratnikov.HW.dao.IngredientDao;
import com.ratnikov.HW.model.Ingredient;
import org.h2.tools.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JdbcTemplateConfig.class)
public class TestJdbcTemplate {

    @BeforeAll
    public static void startServer() throws SQLException {
        Server.createTcpServer().start();
    }

    @Autowired
    public IngredientDao ingredientDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @AfterEach
    public void clear() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "INGREDIENT", "RECIPE");
    }

    @Test
    public void createBatchIngredients() {
        Ingredient egg = new Ingredient();
        egg.setName("Яйцо");
        egg.setKolvo("5 штук");

        Ingredient flour = new Ingredient();
        flour.setName("Мука");
        flour.setKolvo("200 грамм");

        ingredientDao.createIngredients(egg, flour);

        ingredientDao.showIngredients();
    }

    private List<Ingredient> getSomeIngredients(int cnt) {
        return IntStream.rangeClosed(0, cnt).mapToObj(i -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setName("Ингредиент: " + i);
            return ingredient;
        }).collect(Collectors.toList());
    }
}

