/*
 *  Decorator Design Pattern
 *      - It allows us to dynamically add functionality and behavior to an object without affecting the behavior 
 *        of other existing objects within the same class. 
 *      - We use inheritance to extend the behavior of the class. This takes place at compile-time, and all the 
 *        instances of that class get the extended behavior.
 *  Exp:
 *      Pizza Billing.
 *      Coffie Billing.
 */

import helperInterfaces.BasePizza;
import helperInterfaces.ToppingDecorator;

class FarmhousePizza extends BasePizza {
    @Override
    public int cost() {
        return 200;
    }
}

class MargheritaPizza extends BasePizza {
    @Override
    public int cost() {
        return 100;
    }
}

class ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;

    ExtraCheese(BasePizza pizza) {
        basePizza = pizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 10;
    }
}

class Mushroom extends ToppingDecorator {
    BasePizza basePizza;

    Mushroom(BasePizza pizza) {
        basePizza = pizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 20;
    }
}

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        BasePizza  pizza = new Mushroom(new ExtraCheese(new FarmhousePizza()));
        System.out.println("Pizza Cost After Topping: " + pizza.cost());
    }
}
