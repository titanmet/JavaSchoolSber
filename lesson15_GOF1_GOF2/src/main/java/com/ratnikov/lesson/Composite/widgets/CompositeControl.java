package com.ratnikov.lesson.Composite.widgets;

import java.util.ArrayList;
import java.util.List;

public class CompositeControl extends UIComponent {
    protected final static char COMPOSITE_FRAME = '+';

    protected List<UIComponent> children = new ArrayList<>();

    public CompositeControl add(UIComponent c) {
        children.add(c);
        return this;
    }

    public void remove(UIComponent c) {
        children.remove(c);
    }

    public List<UIComponent> getChildren() {
        return children;
    }

    public void draw() {
        for (int i = 0; i < getHeight(); i++) {
            draw(i);
        }
    }

    private void printBorder() {
        for (int i = 0; i < getWidth(); i++) {
            System.out.print(COMPOSITE_FRAME);
        }
    }

    @Override
    public boolean draw(int line) {
        if (line == 0 || line == getHeight() - 1) {
            printBorder();
            drawLineFinish();
            return true;
        }
        if (line > 0 && line < getHeight() - 1) {
            System.out.print(COMPOSITE_FRAME);
            for (UIComponent c : children)
                if (!c.draw(line - 1))
                    for (int i = 0; i < c.getWidth(); i++)
                        System.out.print(' ');
            drawLineFinish();
            return true;
        }
        return false;
    }

    public void drawLineFinish() {
        System.out.println(COMPOSITE_FRAME);
    }

    @Override
    public int getHeight() {
        int max = 0;
        for (UIComponent c : children)
            if (c.getHeight() > max)
                max = c.getHeight();
        return max + 2;
    }

    @Override
    public int getWidth() {
        int summa = 0;
        for (UIComponent c : children)
            summa += c.getWidth();
        return summa + 2;

    }
}
