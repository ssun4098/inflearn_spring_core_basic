package com.ssun.springstudyhello.singleton;

public class SingletonService {

    private static final SingletonService INSTANCE = new SingletonService();

    public static SingletonService getInstance() {
        return INSTANCE;
    }

    private SingletonService() {}

    public void sayHello() {
        System.out.println("sayHello");
    }
}
