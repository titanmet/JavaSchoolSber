package com.ratnikov.lesson.Composite.widgets;

public class Button extends ContentControl{
    final static char BUTTON_FRAME = '*';

    public Button() {
        super();
    }

    public Button(String text) {
        super(text);
    }

    private void printBorder() {
        for(int i = 0; i < getText().length(); i++)
            System.out.print(BUTTON_FRAME);
    }
    @Override
    public boolean draw(int line) {
        if (line == 0 || line == 2) {
            System.out.print(BUTTON_FRAME);
            printBorder();
            System.out.print(BUTTON_FRAME);
            return true;
        }
        if (line == 1) {
            System.out.print(BUTTON_FRAME);
            System.out.print(getText());
            System.out.print(BUTTON_FRAME);
            return true;
        }
        return false;
    }


    @Override
    public int getHeight() {
        return 3;
    }

}
