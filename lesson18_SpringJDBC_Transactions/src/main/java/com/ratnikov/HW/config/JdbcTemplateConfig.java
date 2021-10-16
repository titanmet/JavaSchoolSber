package com.ratnikov.HW.config;

import com.ratnikov.HW.dao.IngredientDao;
import com.ratnikov.HW.dao.IngredientDaoImpl;
import com.ratnikov.HW.dao.RecipeDao;
import com.ratnikov.HW.dao.RecipeDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Import(DataConfiguration.class)
public class JdbcTemplateConfig {
    @Bean
    public IngredientDao ingredientDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        return new IngredientDaoImpl(dataSource, jdbcTemplate);
    }
    @Bean
    public RecipeDao recipeDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        return new RecipeDaoImpl(dataSource, jdbcTemplate);
    }
}
