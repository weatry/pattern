package com.github.budwing.pattern.proxy;

public class User extends AbstractUser {
    private String username;
    @Override
    public String getName() {
        return username;
    }
}
