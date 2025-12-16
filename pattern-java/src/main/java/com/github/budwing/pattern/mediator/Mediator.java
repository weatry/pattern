package com.github.budwing.pattern.mediator;

public interface Mediator {
    void notify(Colleague source, String msg);
}
