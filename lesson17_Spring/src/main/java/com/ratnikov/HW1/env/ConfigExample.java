package com.ratnikov.HW1.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configurable
@PropertySource("classpath:app.properties")
public class ConfigExample {
    @Autowired
    private Environment env;

    @Value("${com.ratnikov.testBean.num}")
    private Integer num;


    @Bean
    public TestBean testBean() {
        System.out.println("num = " + num);
        return new TestBean(env.getProperty("com.ratnikov.testBean.timeout", Integer.class, 1000));
    }
}
