package com.pkslow.basic.jdk;

public class Bird implements Flyable {
    @Override
    public String fly(String route) {
        System.out.println("Route: " + route);
        return route;
    }
}
