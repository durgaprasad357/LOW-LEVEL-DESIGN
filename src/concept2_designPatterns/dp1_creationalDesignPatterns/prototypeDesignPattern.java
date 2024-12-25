/*
    Prototype Design Pattern :
    - Prototype allows us to hide the complexity of making new instances from the client.
    - The concept is to copy an existing object rather than creating a new instance from scratch, 
      something that may include costly operations.
*/


/*
class Student {
    int age;
    private int rollNumber;
    String name;

    Student(){}
    Student(int age, int rollNumber, String name) {
        this.age = age;
        this.name = name;
        this.rollNumber = rollNumber;
    }
    void getStudentInfo(){
        System.out.println("Student Info: ");
        System.out.println("name: " + name + ", age : " + age +  ", rollNumber: " + rollNumber);
    }
}

public class prototypeDesignPattern {
    public static void main(String[] args) {
        Student baseObj = new Student(21, 1, "Prasad");
        baseObj.getStudentInfo();


        Student colneObj = new Student();
        colneObj.name = baseObj.name;
        colneObj.age = baseObj.age;
        // colneObj.rollNumber = baseObj.rollNumber;
        colneObj.getStudentInfo();
    }
}
*/


/*
 *  Major Problems :
 *      cloning private instance variables.
 *      out of huge no of instance var's, what all should be allowed to clone.
 *  In the above code if we assign the baseObj values to the colneObj, it will throw error because we won;t be able to get the private instance objects of baseObj.
 *  we can abole to set the values using getters and setters, but most of the times private objects will always get protected with private methods.
 *
 *  Using Prototype design patters will solve those above two problems: Below Code.
 *      The base class will provide the cloning functionality, due to this private instance variables will be available always.
 *      The base class it self will decide what are all the instance var's should get cloned. 
 */


import helperInterfaces.Prototype;

class Student implements Prototype {
    int age;
    private int rollNumber;
    String name;

    Student() {
    }

    Student(String name, int age, int rollNumber) {
        this.age = age;
        this.name = name;
        this.rollNumber = rollNumber;
    }

    void getStudentInfo() {
        System.out.println("name: " + name + ", age : " + age + ", rollNumber: " + rollNumber);
    }

    @Override
    public Prototype clone() {
        return new Student(name, age, rollNumber);
    }
}

public class prototypeDesignPattern {
    public static void main(String[] args) {
        Student baseObj = new Student("Prasad", 21, 1);
        System.out.println("baseObj Info: ");
        baseObj.getStudentInfo();

        Student colneObj = (Student) baseObj.clone();
        System.out.println("colneObj Info: ");
        colneObj.getStudentInfo();
    }
}