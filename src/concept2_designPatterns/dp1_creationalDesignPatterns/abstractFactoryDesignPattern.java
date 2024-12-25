
/* 
 *  Abstract Factory Method Design Pattern
 *      - Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction 
 *        over factory pattern.
 *      - Abstract Factory patterns work around a super-factory which creates other factories.
*/

import helperInterfaces.AbstractFactory;
import helperInterfaces.Car;

class EconomyCar1 extends Car {
    EconomyCar1() {
        this.type = "Petrol";
        this.noOfSeets = 4;
    }

    @Override
    public void getCarDetails() {
        System.out.println("EconomyCar1 : Runs With : " + type + ", No Of Seets: " + noOfSeets);
    }
}

class EconomyCar2 extends Car {
    EconomyCar2() {
        this.type = "Diesel";
        this.noOfSeets = 7;
    }

    @Override
    public void getCarDetails() {
        System.out.println("EconomyCar2 : Runs With : " + type + ", No Of Seets: " + noOfSeets);
    }
}

class LuxuryCar1 extends Car {
    LuxuryCar1() {
        this.type = "Petrol";
        this.noOfSeets = 4;
    }

    @Override
    public void getCarDetails() {
        System.out.println("LuxuryCar1 : Runs With : " + type + ", No Of Seets: " + noOfSeets);
    }
}

class LuxuryCar2 extends Car {
    LuxuryCar2() {
        this.type = "Diesel";
        this.noOfSeets = 7;
    }

    @Override
    public void getCarDetails() {
        System.out.println("LuxuryCar2 : Runs With : " + type + ", No Of Seets: " + noOfSeets);
    }

}

class EconomyCarFactory implements AbstractFactory {
    @Override
    public Car getInstance(int price) {
        if (price <= 1000000)
            return new EconomyCar1();
        else if (price <= 2000000)
            return new EconomyCar2();
        return null;
    }
}

class LuxuryCarFactory implements AbstractFactory {
    @Override
    public Car getInstance(int price) {
        if (price <= 3000000)
            return new LuxuryCar1();
        else if (price <= 4000000)
            return new LuxuryCar2();
        return null;
    }
}

class AbstractFactoryProducer {
    public AbstractFactory getAbstractFactory(String carType) {
        if (carType.toLowerCase().equals("economy"))
            return new EconomyCarFactory();
        else if (carType.toLowerCase().equals("luxury"))
            return new LuxuryCarFactory();
        return null;
    }
}

public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        AbstractFactoryProducer abstractFactoryProducerObj = new AbstractFactoryProducer();

        AbstractFactory abstractFactoryObj1 = abstractFactoryProducerObj.getAbstractFactory("Economy");
        Car carObj1 = abstractFactoryObj1.getInstance(500000);
        carObj1.getCarDetails();

        Car carObj2 = abstractFactoryObj1.getInstance(1500000);
        carObj2.getCarDetails();

        AbstractFactory abstractFactoryObj2 = abstractFactoryProducerObj.getAbstractFactory("Luxury");
        Car carObj3 = abstractFactoryObj2.getInstance(2500000);
        carObj3.getCarDetails();

        Car carObj4 = abstractFactoryObj2.getInstance(3500000);
        carObj4.getCarDetails();
    }
}
