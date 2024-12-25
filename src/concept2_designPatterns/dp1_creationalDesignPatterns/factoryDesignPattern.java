/*
 *  Factory Design Pattern
 *      - This pattern is typically helpful when it's necessary to separate the construction of an object from 
 *        its implementation.
 *      - With the use of this design pattern, objects can be produced without having to define the exact class of object 
 *        to be created.
 *      - Its primary purpose is to provide a way to create objects without specifying the exact class of object that will 
 *        be created. It defines an interface or abstract class for creating an object but lets subclasses or other classes 
 *        decide which class to instantiate.
 *      - When you need to create objects without knowing the exact class of the object at compile time.
 *      - When the instantiation logic is complex and you want to centralize it.
 *      - it is used when all the object creation and it's business logic we need to keep it at one place.
 */

import helperInterfaces.Shape;

class Circle implements Shape {
    @Override
    public void computeArea() {
        System.out.println("Circle area.");
    }
}

class Square implements Shape {
    @Override
    public void computeArea() {
        System.out.println("Square area.");
    }
}

class RectAngle implements Shape {
    @Override
    public void computeArea() {
        System.out.println("RectAngle area.");
    }
}

class ShapeInstanceFactory {
    public Shape getShapeInstance(String type) {
        if (type.toLowerCase().equals("circle"))
            return new Circle();
        else if (type.toLowerCase().equals("rectangle"))
            return new RectAngle();
        else if (type.toLowerCase().equals("square"))
            return new Square();
        return null;
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        ShapeInstanceFactory factoryObj = new ShapeInstanceFactory();

        Shape circleObj = factoryObj.getShapeInstance("Circle");
        circleObj.computeArea();

        Shape squareObj = factoryObj.getShapeInstance("Square");
        squareObj.computeArea();

        Shape rectAngleObj = factoryObj.getShapeInstance("RectAngle");
        rectAngleObj.computeArea();
    }
}
