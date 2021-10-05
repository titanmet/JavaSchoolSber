package com.ratnikov.lesson.Prototype;

public class ColorPoint extends Point implements Prototype {
    String color;

    public ColorPoint(int x, int y, String color) {
        super (x,y);
        this.color = color;
    }

    public ColorPoint(ColorPoint p) {
        this(p.x, p.y, p.color);
    }

    @Override
    public ColorPoint Clone() {
        return new ColorPoint(this);
    }
    @Override
    public String toString() {
        return String.format("Color Point (%d,%d) %s", x,y, color);
    }

}
