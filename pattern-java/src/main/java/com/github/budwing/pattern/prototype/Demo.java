package com.github.budwing.pattern.prototype;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setId(1);
        user.setName("tom");
        user.setAge(22);

        User user1 = (User)user.clone();
        System.out.println(user==user1);
        System.out.println(user.getId()==user1.getId());
    }
}
