package com.ratnikov.lesson.Prototype;

import java.util.HashMap;
import java.util.Map;

public class Program {
    static final Point DEFAULT_POINT = new Point(0, 0);

    // реестр доступных прототипов
    static Map<String, Prototype> protos;
    static {
        protos = new HashMap<String, Prototype>();
        protos.put("default", new ColorPoint(0, 0, "black"));
        protos.put("red", new ColorPoint(0, 0, "red"));
        protos.put("green", new ColorPoint(0, 0, "green"));
    }

    public static Point  createPoint() {
        return DEFAULT_POINT.clone();
    }
    public static void main(String[] args) {

        Point p = createPoint();
        System.out.println(p);

        Prototype red = Prototype.createRedPoint(); // возвращает ColorPoint
        System.out.println(red);
    }
}
