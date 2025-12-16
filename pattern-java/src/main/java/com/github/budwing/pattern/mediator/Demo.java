package com.github.budwing.pattern.mediator;

public class Demo {
    public static void main(String[] args) {
        TextBox textBox = new TextBox("TextBox");
        Button button = new Button("Button");
        TextBoxButtonMediator mediator = new TextBoxButtonMediator(textBox, button);
        textBox.setMediator(mediator);
        button.setMediator(mediator);
        textBox.setText("Hello World");
        button.click();
    }
}
