package javaapplication1.Inheritance.DeepCopy;

public class Vehicle {

    public static void main(String[] args) throws CloneNotSupportedException {
        Car c1 = new Car("BMW", "red", new Engine(2000, "petrol"));

        c1.setBrandName("Ferrari");
        c1.setColor("Red");
        System.out.println(c1);
        
        System.out.println("******** COPY_CLONE ******************************");

        Car copyCar = (Car) c1.clone();

        copyCar.setBrandName("Ford Mustang");
        copyCar.setColor("Green");
//        copyCar.eng.setPower(5000);
//        copyCar.eng.setFuelType("Diesel");
        System.out.println(copyCar);
        
        System.out.println("********** ORG ****************************");
        
        System.out.println(c1);
    }
}
