package com.ratnikov.jdbc_lesson.dao;

import com.ratnikov.jdbc_lesson.model.Animal;
import com.ratnikov.jdbc_lesson.model.Person;

import java.util.List;
import java.util.Set;

/**
 * Работа с животными
 */
public interface AnimalDao {
    /**
     * Создать животное
     * @param name кличка
     * @param type вид
     * @return животное
     */
    Animal createAnimal(String name, String type);

    /**
     * Получить всех животных
     * @return животные
     */
    Set<Animal> getAnimals();

    /**
     * создать несколько животных
     * @param animals животные
     */
    void createAnimals(List<Animal> animals);

    /**
     * найти животное
     * @param name кличка
     * @param type вид
     * @return животное
     */
    Animal findAnimal(String name, String type);

    /**
     * Продать животное
     * @param animal животное
     * @param person покупатель
     */
    void sellAnimal(Animal animal, Person person);
}