package com.ssun.springstudyhello.singleton;

public class StatefulService {

    private int price;

    public void order(String name, int price) {
        System.out.println(name + " " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
