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