package car;

public class Car implements Comparable<Car> {
    Long id;
    String model;
    String type;

    public Car(Long id, String model, String type) {
        this.id = id;
        this.model = model;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return this.getType().equals(((Car)o).getType());
    }


    @Override
    public int compareTo(Car o) {
        return this.getType().compareTo(o.getType());
    }

}
