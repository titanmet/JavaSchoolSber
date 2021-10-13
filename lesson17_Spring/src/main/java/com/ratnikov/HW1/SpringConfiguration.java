package com.ratnikov.HW1;

import com.ratnikov.HW1.dao.FibonachiDaoImpl;
import com.ratnikov.HW1.env.ConfigExample;
import com.ratnikov.HW1.service.H2DB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;


@Configuration
@ComponentScan("com.ratnikov.HW1")
@Import(ConfigExample.class)
public class SpringConfiguration {

    @Bean
    H2DB service(FibonachiDaoImpl bean) {
        return new H2DB(bean);
    }
}
