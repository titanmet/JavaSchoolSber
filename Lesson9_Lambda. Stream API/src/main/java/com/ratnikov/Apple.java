package com.ratnikov;

public class Apple {
    Integer size = 1;
    String color;

    public Apple() {

    }

    public Apple(Integer size, String color) {
        this.size = size;
        this.color = color;
    }

    public void serSizeByApple(Apple apple){
        this.size = apple.size;
    }


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
