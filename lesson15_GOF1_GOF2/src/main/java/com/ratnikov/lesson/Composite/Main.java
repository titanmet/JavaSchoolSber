package com.ratnikov.lesson.Composite;

import com.ratnikov.lesson.Composite.widgets.Button;
import com.ratnikov.lesson.Composite.widgets.CompositeControl;
import com.ratnikov.lesson.Composite.widgets.Label;
import com.ratnikov.lesson.Composite.widgets.MainWindow;

public class Main {
    public static void main(String[] args) {
        CompositeControl mainWin = new MainWindow();
        CompositeControl frame1 = new CompositeControl();
        CompositeControl frame2 = new CompositeControl();
        frame1.add(new Label("Login")).add(new Button("OK"));
        frame2.add(new Label("Password")).add(new Button("Verify"));
        mainWin.add(frame1).add(frame2).add(new CompositeControl().add(new Button("Print")));

        mainWin.draw();
    }
}
