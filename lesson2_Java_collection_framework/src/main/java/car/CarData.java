package car;

import java.util.Collection;
import java.util.Iterator;

public class CarData {

    public static Collection<Car> init(Collection<Car> cars) {
        cars.add(new Car(1L,"Lada", "Sedan"));
        cars.add(new Car(2L,"Lada", "Hatchback"));
        cars.add(new Car(3L,"Mersedes", "Sedan"));
        cars.add(new Car(4L,"BMW", "Сrossover"));
        cars.add(new Car(5L,"Ford", "Sedan"));
        cars.add(new Car(6L,"Ford", "Hatchback"));
        cars.add(new Car(7L,"Peugeot", "Sedan"));
        cars.add(new Car(8L,"Peugeot", "Сrossover"));
        cars.add(new Car(9L,"Toyota", "Sedan"));
        cars.add(new Car(10L,"Kia", "Hatchback"));

        return cars;
    }

    public static void print(Collection<Car> cars){

        Iterator<Car> it = cars.iterator();

        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
