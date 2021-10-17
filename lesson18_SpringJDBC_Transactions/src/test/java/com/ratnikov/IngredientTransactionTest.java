package com.ratnikov;

import com.ratnikov.HW.config.TransactionalConfig;
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
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TransactionalConfig.class)
public class IngredientTransactionTest {

    @Autowired
    public IngredientDao ingredientDao;

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @BeforeAll
    public static void startServer() throws SQLException {
        Server.createTcpServer().start();
    }

    @AfterEach
    public void clear() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "INGREDIENT", "RECIPE");
    }

    @Test
    public void nonTransactionUpdate() {
        Ingredient ingr = new Ingredient();
        ingr.setRecipe_id(1);
        ingr.setName("Масло");
        ingr.setKolvo("100 грамм");
        Ingredient ingr1 = new Ingredient();
        ingr1.setRecipe_id(1);
        ingr1.setName("Марковка");
        ingr1.setKolvo("1 штука");
        ingredientDao.createSimpleIngredient(ingr);
        ingredientDao.createSimpleIngredient(ingr1);
        ingredientDao.showIngredients();
        try {
            ingredientDao.updateKolvo(ingr, "1 кг");
            ingredientDao.updateKolvo(ingr1, "10 штук");
        } catch (Exception e) {
            System.err.println("Error");
        }
        ingredientDao.showIngredients();
    }

    @Test
    public void manualTransactionUpdate() {
        Ingredient ingr = new Ingredient();
        ingr.setRecipe_id(1);
        ingr.setName("Масло");
        ingr.setKolvo("100 грамм");
        Ingredient ingr1 = new Ingredient();
        ingr1.setRecipe_id(1);
        ingr1.setName("Марковка");
        ingr1.setKolvo("1 штука");
        ingredientDao.createSimpleIngredient(ingr);
        ingredientDao.createSimpleIngredient(ingr1);

        ingredientDao.showIngredients();
        ingredientDao.manualTransactionUpdateKolvo(Arrays.asList(ingr, ingr1));
        ingredientDao.showIngredients();
    }

    @Test
    public void templateTransactionUpdate() {
        Ingredient ingr = new Ingredient();
        ingr.setRecipe_id(1);
        ingr.setName("Масло");
        ingr.setKolvo("100 грамм");
        Ingredient ingr1 = new Ingredient();
        ingr1.setRecipe_id(1);
        ingr1.setName("Марковка");
        ingr1.setKolvo("1 штука");
        ingredientDao.createSimpleIngredient(ingr);
        ingredientDao.createSimpleIngredient(ingr1);

        ingredientDao.showIngredients();
        ingredientDao.templateTransactionUpdateKolvo(Arrays.asList(ingr, ingr1));
        ingredientDao.showIngredients();
    }

    @Test
    public void annotationTransactionUpdate() {
        Ingredient ingr = new Ingredient();
        ingr.setRecipe_id(1);
        ingr.setName("Масло");
        ingr.setKolvo("100 грамм");
        Ingredient ingr1 = new Ingredient();
        ingr1.setRecipe_id(1);
        ingr1.setName("Марковка");
        ingr1.setKolvo("1 штука");
        ingr = ingredientDao.createSimpleIngredient(ingr);
        ingr1 = ingredientDao.createSimpleIngredient(ingr1);

        ingredientDao.showIngredients();
        ingredientDao.annotationUpdateKolvo(Arrays.asList(ingr, ingr1));
        ingredientDao.showIngredients();
    }



}
