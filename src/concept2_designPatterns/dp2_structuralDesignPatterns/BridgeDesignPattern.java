/*
 *  Bridge Design Pattern:
 *      - This pattern helps to decouple an abstraction from it's implementation, so that two can vary independently.
 * 
 *      - The bridge pattern allows the Abstraction and the Implementation to be developed independently.
 *      - The client code can access only the Abstraction part without being concerned about the Implementation part.
 */

/*
abstract class LivingThings {
    abstract void breathProcess();
}

class Human extends LivingThings {
    @Override
    void breathProcess() {
        System.out.println("Breath through nose.");
        System.out.println("Take Oxygen.");
        System.out.println("Leave carbon dioxide.");
    }
}

class Fish extends LivingThings {
    @Override
    void breathProcess() {
        System.out.println("Breath through gills.");
        System.out.println("Take Oxygen.");
        System.out.println("Leave carbon dioxide.");
    }
}

class Tree extends LivingThings {
    @Override
    void breathProcess() {
        System.out.println("Breath through leaves.");
        System.out.println("Take carbon dioxide.");
        System.out.println("Leave Oxygen.");
    }
}

public class BridgeDesignPattern {
    public static void main(String[] args) {
        System.out.println("Humaa:");
        LivingThings obj1 = new Human();
        obj1.breathProcess();
        System.out.println();

        System.out.println("Fish:");
        LivingThings obj2 = new Fish();
        obj2.breathProcess();
        System.out.println();

        System.out.println("Tree:");
        LivingThings obj3 = new Tree();
        obj3.breathProcess();
        System.out.println();
    }
}
*/

/*.
    In the above code, the living things and the breathProcess is tightly coupled, 
        - We won't be able to create a breathProcess with out a new LivingThings, These two got tightly coupled
    
    After converting the above code into BridgeDesignPattern: Below code.
        - To be able to create a new breathProcess, we nedd to separate the breathProcess and LivingThings.
        - So that we can able to create a new breathProcess, and can work independently.
*/

import helperInterfaces.BreathImplementor;

class LandBreath implements BreathImplementor {
    @Override
    public void breathProcess() {
        System.out.println("Breath through nose.");
        System.out.println("Take Oxygen.");
        System.out.println("Leave carbon dioxide.");
    }
}

class WaterBreath implements BreathImplementor {
    @Override
    public void breathProcess() {
        System.out.println("Breath through gills.");
        System.out.println("Take Oxygen.");
        System.out.println("Leave carbon dioxide.");
    }
}

class TreeBreath implements BreathImplementor {
    @Override
    public void breathProcess() {
        System.out.println("Breath through leaves.");
        System.out.println("Take carbon dioxide.");
        System.out.println("Leave Oxygen.");
    }
}

abstract class LivingThings {
    BreathImplementor breathingImplementor;

    LivingThings(BreathImplementor breathingImplementor) {
        this.breathingImplementor = breathingImplementor;
    }

    abstract void breathProcess();
}

class Human extends LivingThings {
    Human(BreathImplementor breathingImplementor) {
        super(breathingImplementor);
    }

    @Override
    void breathProcess() {
        breathingImplementor.breathProcess();
    }
}

class Fish extends LivingThings {
    Fish(BreathImplementor breathingImplementor) {
        super(breathingImplementor);
    }

    @Override
    void breathProcess() {
        breathingImplementor.breathProcess();
    }
}

class Tree extends LivingThings {
    Tree(BreathImplementor breathingImplementor) {
        super(breathingImplementor);
    }

    @Override
    void breathProcess() {
        breathingImplementor.breathProcess();
    }
}

public class BridgeDesignPattern {
    public static void main(String[] args) {

        System.out.println("Humaa:");
        LivingThings obj1 = new Human(new LandBreath());
        obj1.breathProcess();
        System.out.println();

        System.out.println("Fish:");
        LivingThings obj2 = new Fish(new WaterBreath());
        obj2.breathProcess();
        System.out.println();

        System.out.println("Tree:");
        LivingThings obj3 = new Tree(new TreeBreath());
        obj3.breathProcess();
        System.out.println();
    }
}