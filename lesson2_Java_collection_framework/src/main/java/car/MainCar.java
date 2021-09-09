package car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainCar {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        CarData.init(cars);
        Collections.sort(cars);
        CarData.print(cars);

        System.out.println("--------------------------------------------------");
        List<Car> sedan = cars.stream().filter((p)-> p.getType().equals("Sedan")).collect(Collectors.toList());
        sedan.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        List<Car> hatchback = cars.stream().filter((p)-> p.getType().equals("Hatchback")).collect(Collectors.toList());
        hatchback.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        List<Car> crossover= cars.stream().filter((p)-> p.getType().equals("Сrossover")).collect(Collectors.toList());
        crossover.forEach(System.out::println);
    }
}
