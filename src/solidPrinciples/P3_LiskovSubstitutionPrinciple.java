/*
    L  - Liskov Substitution Principle
        A subclass should extend the capability of a parent class not narrow it down.
        Exp: If class B is subtype of class A, Then we should be able to replace object of A with object of B,
             Without breaking the behaviour of the program.
*/


 /*
import java.util.ArrayList;
import java.util.List;

class Vehicle {
    String turnOnEngine() {
        return "Engine Started.";
    }

    int getNoOfWheels() {
        return 2;
    }
}

class MotorCycle extends Vehicle {
    String vehicleName = "MotorCycle";

    @Override
    public String turnOnEngine() {
        return this.vehicleName + " " + super.turnOnEngine();
    }
}

class BiCycle extends Vehicle {
    String vehicleName = "BiCycle";

    @Override
    public String turnOnEngine() {
        // BiCycle doesn't have an engine.
        return null;
    }

    @Override
    int getNoOfWheels() {
        return 2;
    }
}

class Car extends Vehicle {
    String vehicleName = "Car";

    @Override
    public String turnOnEngine() {
        return this.vehicleName + " " + super.turnOnEngine();
    }

    @Override
    int getNoOfWheels() {
        return 4;
    }
}

public class P3_LiskovSubstitutionPrinciple {
    static void startAllVehicles(List<Vehicle> ls) {
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i).turnOnEngine().toString());
        }
    }

    public static void main(String[] args) {
        List<Vehicle> ls = new ArrayList<>();
        ls.add(new MotorCycle());
        ls.add(new Car());
        ls.add(new BiCycle());

        startAllVehicles(ls);
    }
}
*/


/*.
    In the above code, the Vehicle class was violating the Liskov Substitution Principle.
        - We have parent class that has functionality that won't applibale for all the Vehicle, due to this some the 
          childs narrowing it down the functionality.
    
    After converting the Vehicle class to follow LSP: Below code.
        - Proper Abstraction: The Vehicle class only includes functionality common to all vehicles.
        - Specialized Subclasses: Engine vehicles (Car, MotorCycle) inherit EngineVehicles, 
          while non-engine vehicles (BiCycle) inherit Vehicle.
        - Polymorphism: Methods like startAllEngineVehicles() and getAllVehiclesWheels() operate on appropriate types, 
          ensuring logical correctness and compile-time safety.
        - Avoiding Overriding/Unused Methods: Non-engine vehicles no longer override irrelevant methods like turnOnEngine().
*/


import java.util.ArrayList;
import java.util.List;

class Vehicle {
    protected String vehicleName;

    int getNoOfWheels() {
        return 2;
    }
}

class EngineVehicles extends Vehicle {
    String turnOnEngine() {
        return "Engine Started.";
    }
}

class MotorCycle extends EngineVehicles {
    public MotorCycle() {
        this.vehicleName = "MotorCycle";
    }

    @Override
    public String turnOnEngine() {
        return this.vehicleName + " " + super.turnOnEngine();
    }
}

class BiCycle extends Vehicle {
    public BiCycle() {
        this.vehicleName = "BiCycle";
    }
}

class Car extends EngineVehicles {
    public Car() {
        this.vehicleName = "Car";
    }

    @Override
    public String turnOnEngine() {
        return this.vehicleName + " " + super.turnOnEngine();
    }

    @Override
    int getNoOfWheels() {
        return 4;
    }
}

public class P3_LiskovSubstitutionPrinciple {
    static void startAllEngineVehicles(List<EngineVehicles> ls) {
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i).turnOnEngine());
        }
        System.out.println();
    }

    static void getAllVehiclesWheels(List<Vehicle> ls) {
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i).vehicleName + " has " + ls.get(i).getNoOfWheels() + " wheels.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<EngineVehicles> ls1 = new ArrayList<>();
        ls1.add(new MotorCycle());
        ls1.add(new Car());
        // ls1.add(new BiCycle()); // this will throw compile time error.
        System.out.println("All Engine Vehicles:");
        startAllEngineVehicles(ls1);

        List<Vehicle> ls2 = new ArrayList<>();
        ls2.add(new MotorCycle());
        ls2.add(new Car());
        ls2.add(new BiCycle());
        System.out.println("All Vehicles:");
        getAllVehiclesWheels(ls2);
    }
}
