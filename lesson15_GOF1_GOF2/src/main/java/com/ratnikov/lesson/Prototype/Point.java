package com.ratnikov.lesson.Prototype;

public class Point implements Cloneable {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this(p.x, p.y);
    }

    @Override
    public Point clone() {
        return new Point(this);
    }

    @Override
    public String toString() {
        return String.format("Point (%d,%d)", x,y);
    }

}
