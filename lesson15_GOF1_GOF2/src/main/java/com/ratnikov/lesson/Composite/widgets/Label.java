package com.ratnikov.lesson.Composite.widgets;

public class Label extends ContentControl {
    public Label(String text) {
        super(text);
    }

    @Override
    public boolean draw(int line) {
        if(line == 0) {
            System.out.printf(" %s ", getText());
            return true;
        }
        return false;
    }
}
