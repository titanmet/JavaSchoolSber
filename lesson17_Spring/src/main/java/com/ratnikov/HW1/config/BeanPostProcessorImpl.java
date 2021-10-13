package com.ratnikov.HW1.config;

import com.ratnikov.HW1.connection.DataSourceHelper;
import com.ratnikov.HW1.dao.FibonachiDaoImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.Statement;


@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        try (Statement statement = DataSourceHelper.connection().createStatement()) {
            statement.executeUpdate("truncate table FIBONACHI");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof FibonachiDaoImpl) {
            return new DecoratorBean((FibonachiDaoImpl) bean);
        }
        return bean;
    }


    private class DecoratorBean extends FibonachiDaoImpl {
        private final FibonachiDaoImpl delegate;

        public DecoratorBean(FibonachiDaoImpl bean) {
            this.delegate = bean;
        }

        @Override
        public void predestroyFibonachi() {
            System.out.println("--------PostProcessor predestroyFibonachi-----------");
        }
    }
}
