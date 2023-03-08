package com.github.budwing.pattern.proxy.lazyinit;

import java.sql.Connection;

public class UserProxy extends AbstractUser {
    private User user;
    private Connection connection;

    public UserProxy(User user) {
        this.user = user;
    }

    @Override
    public String getName() {
        if (user.getName()==null) {
            init();
        }

        return user.getName();
    }

    public void init() {
        //connection.createStatement();
    }
}
