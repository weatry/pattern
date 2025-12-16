package com.github.budwing.pattern.mediator;

public class TextBoxButtonMediator implements Mediator {
    private TextBox textBox;
    private Button button;

    public TextBoxButtonMediator(TextBox textBox, Button button) {
        this.textBox = textBox;
        this.button = button;
    }

    @Override
    public void notify(Colleague colleague, String eventName) {
        if (colleague instanceof TextBox) {
            switch (eventName) {
                case "textChanged":
                    System.out.println("TextBox text changed, enable the submit button.");
                    button.setEnabled(textBox.getText().length() > 0);
                    break;
            }
        } else if (colleague instanceof Button) {
            switch (eventName) {
                case "click":
                    System.out.println("Button clicked, clear the text.");
                    textBox.setText("");
                    break;
            }
        }
    }
}
