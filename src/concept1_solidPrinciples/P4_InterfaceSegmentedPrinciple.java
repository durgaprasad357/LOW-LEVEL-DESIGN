/*
    I   - Interface Segmented Principle
        An interface such that, Client should not implement unnecessary functions that they do not need.
*/


/*
import helperInterfaces.RestaurantEmployee;

class Waiter implements RestaurantEmployee {
    public void washDishes() {
        // Not my job.
        System.out.println("washDishes: Not my job.");
    }

    public void serveFood() {
        // Yes here is my implementation.
        System.out.println("serveFood: Serving the customer.");
    }

    public void cookFood() {
        // Not my job.
        System.out.println("cookFood: Not my job.");
    }
}

public class P4_InterfaceSegmentedPrinciple {
    public static void main(String args[]) {
        Waiter waiter = new Waiter();
        waiter.washDishes();
        waiter.serveFood();
        waiter.cookFood();
    }
}
*/


/*
    In the above code, the original `Waiter` class violated the Interface Segregation Principle (ISP) by implementing 
    unnecessary methods (such as `washDishes` and `cookFood`) that were not part of its responsibilities.
    
    After converting the code to follow ISP:
    - The interfaces were divided into smaller, specific interfaces based on the role.
    - The `Cheff` class implements `CookInterface` and `MenuDeciderInterface`, making it responsible only for cooking 
      food and deciding the menu.
    - The `Waiter` class implements `WaiterInterface`, focusing only on taking orders and serving food.
    - The `RestaurantHelper` class implements `RestaurantHelperInterface`, focusing on tasks like washing dishes and cleaning tables.
    
    - This design follows the Interface Segregation Principle by ensuring that each class only implements the interfaces 
      that are relevant to its role, avoiding unnecessary methods.
*/

import helperInterfaces.CheffInterface;
import helperInterfaces.RestaurantHelperInterface;
import helperInterfaces.WaiterInterface;

class Cheff implements CheffInterface {
    @Override
    public void decideFoodMenu() {
        // Yes here is my implementation.
        System.out.println("decideFoodMenu: Menu decided.");
    }

    @Override
    public void cookFood() {
        // Yes here is my implementation.
        System.out.println("cookFood: Food prepared.");
    }
}

class Waiter implements WaiterInterface {
    @Override
    public void takeOrder() {
        // Yes here is my implementation.
        System.out.println("takeOrder: Taking order from customer.");
    }

    @Override
    public void serveFood() {
        // Yes here is my implementation.
        System.out.println("serveFood: Serving the customer.");
    }
}

class RestaurantHelper implements RestaurantHelperInterface {
    @Override
    public void washDishes() {
        // Yes here is my implementation.
        System.out.println("washDishes: Dishes washed.");
    }

    @Override
    public void cleanTables() {
        // Yes here is my implementation.
        System.out.println("cleanTables: Tables cleaned.");
    }
}

public class P4_InterfaceSegmentedPrinciple {
    public static void main(String args[]) {

        Cheff cheff = new Cheff();
        cheff.decideFoodMenu();
        cheff.cookFood();

        Waiter waiter = new Waiter();
        waiter.takeOrder();
        waiter.serveFood();

        RestaurantHelper restaurantHelper = new RestaurantHelper();
        restaurantHelper.cleanTables();
        restaurantHelper.washDishes();
    }
}