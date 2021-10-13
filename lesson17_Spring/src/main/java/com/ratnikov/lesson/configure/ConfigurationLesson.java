package com.ratnikov.lesson.configure;

import com.ratnikov.lesson.fabric.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan
@org.springframework.context.annotation.Configuration
public class ConfigurationLesson {

    @Bean
    @Qualifier("hh")
    public IHandler firstServiceHandler() {
        return new FirstServiceHandler();
    }

    @Bean
    public IHandler secondServiceHandler() {
        return new SecondServiceHandler();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IHandler thirdServiceHandler(SingletonLazy singletonLazy) {
        return new ThirdServiceHandler(singletonLazy);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SingletonLazy singletonLazy() {
        return new SingletonLazy();
    }
}
