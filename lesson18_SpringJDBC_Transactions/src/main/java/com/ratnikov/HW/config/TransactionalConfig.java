package com.ratnikov.HW.config;

import com.ratnikov.HW.dao.IngredientDao;
import com.ratnikov.HW.dao.IngredientDaoImpl;
import com.ratnikov.HW.dao.RecipeDao;
import com.ratnikov.HW.dao.RecipeDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@Import(DataConfiguration.class)
@EnableTransactionManagement
public class TransactionalConfig {

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public IngredientDao ingredientDao(DataSource dataSource, PlatformTransactionManager transactionManager,
                                   TransactionTemplate transactionTemplate, JdbcTemplate jdbcTemplate) {
        return new IngredientDaoImpl(dataSource, transactionManager, transactionTemplate, jdbcTemplate) {
        };
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager) {
        return new TransactionTemplate(platformTransactionManager);
    }
}