package com.github.budwing.pattern.mediator;

public class TextBox extends Colleague {
    private String text;

    public TextBox(String name) {
        super(name);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text != null && text.length() > 0) {
            System.out.println("TextBox " + name + ": set text to " + text);
            this.text = text;
            mediator.notify(this, "textChanged");
        }
    }
}
