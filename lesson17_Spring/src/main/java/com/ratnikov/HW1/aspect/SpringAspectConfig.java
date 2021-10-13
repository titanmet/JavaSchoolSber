package com.ratnikov.HW1.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = MyService.class)
@EnableAspectJAutoProxy
public class SpringAspectConfig {
}
