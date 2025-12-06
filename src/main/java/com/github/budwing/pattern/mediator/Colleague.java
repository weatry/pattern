package com.github.budwing.pattern.mediator;

public abstract class Colleague {
    protected String name;
    protected Mediator mediator;

    public Colleague(String name) {
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
