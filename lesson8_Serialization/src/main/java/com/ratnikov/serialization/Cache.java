package com.ratnikov.serialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    String fileNamePrefix() default "ser";

    int listList() default  10_0000;

    boolean zip();

    CacheType cacheType();
}
