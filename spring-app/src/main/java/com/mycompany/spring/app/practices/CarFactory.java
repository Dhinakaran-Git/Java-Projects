package com.mycompany.spring.app.practices;

public class CarFactory {

    public static Car getCar() {
        return new Car("BMW", 22000.0);
    }
}
