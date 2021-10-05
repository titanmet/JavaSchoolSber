package com.ratnikov.lesson.Observer;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        Director director = new Director();
        university.addStudent("Vasya");
        university.addObserver(director);
        university.addStudent("Anna");
        university.removeStudent("Vasya");
    }
}
