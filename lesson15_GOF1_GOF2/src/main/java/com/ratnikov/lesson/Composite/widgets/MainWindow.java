package com.ratnikov.lesson.Composite.widgets;

public class MainWindow extends CompositeControl{
    @Override
    public void drawLineFinish() {
        super.drawLineFinish();
        System.out.println();
    }
}
