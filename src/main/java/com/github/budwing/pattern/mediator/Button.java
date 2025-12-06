package com.github.budwing.pattern.mediator;

public class Button extends Colleague {
    private boolean enabled;

    public Button(String name) {
        super(name);
        this.enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void click() {
        System.out.println(name + " clicked");
        mediator.notify(this, "click");
    }
}
