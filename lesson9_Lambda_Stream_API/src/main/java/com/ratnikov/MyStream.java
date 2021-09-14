package com.ratnikov;

import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class MyStream {
    public static List<Person> someCollection = List.of(new Person("Sam", 25), new Person("Andrea", 65), new Person("Daren", 33));

    public static void main(String[] args) {
        someCollection.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        Map<String, Person> map = Streams.of(someCollection)
            .filter(p ->p.age>30)
                .transform(p->new Person("Mr."+p.getName(),p.getAge()+7))
                .toMap(p->p.name,p->p);

        map.forEach((key, value) -> System.out.println(key + " // " + value));
    }
}

