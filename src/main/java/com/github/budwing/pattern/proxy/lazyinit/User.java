package com.github.budwing.pattern.proxy.lazyinit;

public class User extends AbstractUser {
    private String username;
    @Override
    public String getName() {
        return username;
    }
}
