package ru.sbt.stream.model;

/**
 * Created by i.viktor on 29/08/16.
 */
public class User {
    private final String login;
    private final int id;
    private final int age;

    public User(int id, String login, int age) {
        this.id = id;
        this.login = login;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }
}
