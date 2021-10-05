package com.ratnikov.lesson.Composite.widgets;

public abstract class ContentControl extends UIComponent {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ContentControl() {
        this("");
    }

    public ContentControl(String text) {
        this.text = text;
    }

    @Override
    public int getWidth() {
        return getText().length()+2;
    }

    @Override
    public int getHeight() {
        return 1;
    }
}
