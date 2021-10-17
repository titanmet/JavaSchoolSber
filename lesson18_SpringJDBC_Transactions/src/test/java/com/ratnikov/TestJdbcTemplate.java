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
    public void createIngredient() {
        Ingredient soda = new Ingredient();
        soda.setName("Сода");
        soda.setKolvo("10 грамм");
        ingredientDao.createIngredient(soda);

        ingredientDao.showIngredients();
    }

    @Test
    public void createBatchIngredients() {
        Ingredient egg = new Ingredient();
        egg.setName("Яйцо");
        egg.setKolvo("5 штук");
        Ingredient flour = new Ingredient();
        flour.setName("Мука");
        flour.setKolvo("200 грамм");
        Ingredient water = new Ingredient();
        water.setName("Вода");
        water.setKolvo("1 стакан");

        ingredientDao.createIngredients(egg, flour, water);

        ingredientDao.showIngredients();
    }

    @Test
    public void getAllIngredients() {
        Ingredient flour = new Ingredient();
        flour.setName("Колбаса");
        flour.setKolvo("500 грамм");
        ingredientDao.createIngredients(flour);

        System.out.println(ingredientDao.getIngredients());
    }
}

