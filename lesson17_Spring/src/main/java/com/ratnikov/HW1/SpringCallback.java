package com.ratnikov.HW1;

import com.ratnikov.HW1.dao.FibonachiDao;
import com.ratnikov.HW1.dao.FibonachiDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class SpringCallback {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        FibonachiDao bean = ctx.getBean(FibonachiDao.class);
        FibonachiDao beanPostProcessor = ctx.getBean(FibonachiDaoImpl.class);
        Calculator calculator = new Calculator();
        List<Integer> list = calculator.fibonachi(17);
        bean.createFibonachi(list);

        List<Integer> fibonachi = bean.getFibonachi(15);
        System.out.println(fibonachi);
        System.out.println("-----------------------------------");
        list.forEach(System.out::println);
        beanPostProcessor.predestroyFibonachi();

        ((ConfigurableApplicationContext) ctx).close();
    }
}
