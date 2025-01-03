Types of Design Patterns:
    1) Creational Design Patterns.
        - Creational Design Patterns focus on the process of object creation or problems related to object creation. 
        - They help in making a system independent of how its objects are created, composed and represented.
    2) Structural Design Patterns.
        - Structural Design Patterns solves problems related to how classes and objects are composed/assembled to 
          form larger structures which are efficient and flexible in nature. 
        - Structural class patterns use inheritance to compose interfaces or implementations. 
    3) Behavioral Design Patterns.
        - Behavioral Patterns are concerned with algorithms and the assignment of responsibilities between objects. 
        - Behavioral patterns describe not just patterns of objects or classes but also the patterns of communication between them. These patterns characterize complex control flow that’s difficult to follow at run-time. 



Types of Creational Design Patterns:
    Abstract Factory Method Design Pattern
        - Abstract Factory pattern is almost similar to Factory Pattern and is considered as another layer of abstraction 
          over factory pattern.
        - Abstract Factory patterns work around a super-factory which creates other factories.

    Builder Method Design Pattern
        - To “Separate the construction of a complex object from its representation so that the same construction process 
          can create different representations.” Builder pattern is used
        - It helps in constructing a complex object step by step and the final step will return the object.

    Factory Method Design Pattern
        - This pattern is typically helpful when it's necessary to separate the construction of an object from 
          its implementation.
        - With the use of this design pattern, objects can be produced without having to define the exact class of object 
          to be created.

    Prototype Method Design Pattern
        - Prototype allows us to hide the complexity of making new instances from the client.
        - The concept is to copy an existing object rather than creating a new instance from scratch, something that 
          may include costly operations.
    
    Singleton Method Design Pattern
        - Of all, the Singleton Design pattern is the most straightforward to understand.
        - It guarantees that a class has just one instance and offers a way to access it globally.



Types of Structural Design Patterns:
    Adapter Method Design Pattern
        - The adapter pattern convert the interface of a class into another interface clients expect.
        - Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.

    Bridge Method Design Pattern
        - The bridge pattern allows the Abstraction and the Implementation to be developed independently.
        - The client code can access only the Abstraction part without being concerned about the Implementation part.

    Composite Method Design Pattern
        - As a partitioning design pattern, the composite pattern characterizes a collection of items that are 
          handled  the same way as a single instance of the same type of object.
        - The intent of a composite is to “compose” objects into tree structures to represent part-whole hierarchies.

    Decorator Method Design Pattern
        - It allows us to dynamically add functionality and behavior to an object without affecting the behavior 
          of other existing objects within the same class. 
        - We use inheritance to extend the behavior of the class. This takes place at compile-time, and all the 
          instances of that class get the extended behavior.

    Facade Method Design Pattern
        - Facade Method Design Pattern provides a unified interface to a set of interfaces in a subsystem.
        - Facade defines a high-level interface that makes the subsystem easier to use.

    Flyweight Method Design Pattern
        - This pattern provides ways to decrease object count thus improving application required objects structure.
        - Flyweight pattern is used when we need to create a large number of similar objects.

    Proxy Method Design Pattern
        - Proxy means ‘in place of’, representing’ or ‘in place of’ or ‘on behalf of’ are literal meanings of proxy 
        and that directly explains Proxy Design Pattern.
        - Proxies are also called surrogates, handles, and wrappers. They are closely related in structure, but 
          not purpose, to Adapters and Decorators.

    Reff:
        - https://notebook.zohopublic.in/public/notes/74tdo33c5b7060d544b1c986e519dd3ba4d1b