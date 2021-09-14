package com.ratnikov;

import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloExt {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().reduce((a, b) -> a + b));

        Apple apple = new Apple(10, "red");
        Apple apple1 = new Apple(20, "green");
        AppleTest<Apple> testGreen = a -> "green".equals(a.getColor());
        Predicate<Apple> redPredicat = a -> "red".equals(a.getColor());

        List<Apple> apples = Arrays.asList(apple, apple1);
        apples.forEach(a -> System.out.println(testGreen.testApple(a)));
        Consumer<Apple> green = a -> a.setColor("green");
        Consumer<Apple> size = a -> {
            a.setSize(20);
            System.out.println(a);
        };
        Consumer<Apple> red = a -> a.setColor("red");
        apples.forEach(green);
        apples.forEach(System.out::println);
        System.out.println("------------------------------------------");
        apples.forEach(green.andThen(size));
        apples.forEach(a -> System.out.println(testGreen.testApple(a)));
        System.out.println("------------------------------------------");
        Stream<String> hello = Stream.of("Chess", "Atomic");
        hello.map(p -> p.split(""))
                .flatMap(Arrays::stream)
                .map(String::toUpperCase)
                .map(p -> p + "!")
                .distinct()
                .forEach(System.out::print);
        System.out.println();
        System.out.println("------------------------------------------");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list1.stream().reduce((a, b) -> a * b).stream().collect(Collectors.toList()).forEach(System.out::println);
        list1.stream().filter(p -> p % 2 == 0).forEach(System.out::print);
        System.out.println();
        System.out.println("------------------------------------------");
        list1.stream().reduce(Integer::min).stream().collect(Collectors.toList()).forEach(System.out::println);
        list1.stream().reduce(Integer::max).stream().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        System.out.println("------------------------------------------");
        List<Apple> inventory = Arrays.asList(new Apple(250, "green"), new Apple(350, "red"), new Apple(230, "yellow"));
        List<Apple> heavyApples = inventory.stream().filter(p -> p.getSize()>240).collect(Collectors.toList());
        List<Apple> heavyApples2 = inventory.parallelStream().filter(p->p.getSize()<250).collect(Collectors.toList());
        heavyApples2.forEach(System.out::println);
        System.out.println();
        System.out.println("------------------------------------------");
        heavyApples.forEach(System.out::println);



    }
}
