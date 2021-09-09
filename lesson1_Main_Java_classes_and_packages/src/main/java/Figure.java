

public abstract class Figure {
    abstract void area();

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.area();
        System.out.println();
        Triangle triangle = new Triangle();
        triangle.area();
        System.out.println();
        Rect rect = new Rect();
        rect.area();
        System.out.println();
        Square square = new Square();
        square.area();
    }
}

class Circle extends Figure {
    int radius = 15;
    double area;

    @Override
    public void area() {
        area = Math.PI * (radius * radius);
        System.out.print("Площадь круга: ");
        System.out.printf("%.2f", area);
    }
}

class Rect extends Figure {
    double width = 19;
    double height = 15;
    @Override
    void area() {
        double area = width* height;
        System.out.print("Площадь прямоугольника: ");
        System.out.printf("%.2f", area);
    }
}

class Triangle extends Figure {
    double base = 10;
    double height = 15;
    @Override
    void area() {
        double area = (base* height)/2;
        System.out.print("Площадь треугольника: ");
        System.out.printf("%.2f", area);
    }
}

class Square extends Figure {
    double width = 10;
    double height = 10;
    @Override
    void area() {
        double area = width* height;
        System.out.print("Площадь квадрата: ");
        System.out.printf("%.2f", area);
    }
}
