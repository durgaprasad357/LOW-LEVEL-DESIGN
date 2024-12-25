/*
 *  Builder Method Design Pattern
 *      - It helps in constructing a complex object step by step and the final step will return the object.
 *  Exp:
 *      Coffie(On coffie multiple flawers).
 *      Pizza (On base pizza multiple layers).   
 */

import java.util.List;

abstract class StudentBulder {
    String name;
    int age;
    int rollNumber;
    String fatherName;
    String motherName;
    List<String> subjects;

    public StudentBulder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBulder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBulder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    abstract public StudentBulder setSubjects();

    public StudentBulder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBulder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public Student build() {
        return new Student(this);
    }
}

class EngineeringStudent extends StudentBulder {
    @Override
    public StudentBulder setSubjects() {
        List<String> subjects = List.of("CN", "OS", "DBMS");
        this.subjects = subjects;
        return this;
    }
}

class MbaStudent extends StudentBulder {
    @Override
    public StudentBulder setSubjects() {
        List<String> subjects = List.of("Micro Economics", "Business Studies", "Operations Management");
        this.subjects = subjects;
        return this;
    }
}

class Director {
    StudentBulder studentBulder;

    Director(StudentBulder studentBulder) {
        this.studentBulder = studentBulder;
    }

    public Student createStudent() {
        if (studentBulder instanceof EngineeringStudent)
            return createEngineeringStudent();
        else if (studentBulder instanceof MbaStudent)
            return createMbaStudent();
        return null;
    }

    public Student createEngineeringStudent() {
        return studentBulder.setName("prasad")
                .setAge(25)
                .setRollNumber(52)
                .setFatherName("Prasad-Father")
                .setMotherName("Prasad-Mother")
                .setSubjects()
                .build();
    }

    public Student createMbaStudent() {
        return studentBulder.setName("Durga Prasad")
                .setAge(25)
                .setRollNumber(53)
                .setFatherName("Dp-Father")
                .setMotherName("Dp-Mother")
                .setSubjects()
                .build();
    }
}

class Student {
    String name;
    int age;
    int rollNumber;
    List<String> subjects;
    String fatherName;
    String motherName;

    Student(StudentBulder student) {
        this.name = student.name;
        this.age = student.age;
        this.rollNumber = student.rollNumber;
        this.subjects = student.subjects;
        this.fatherName = student.fatherName;
        this.motherName = student.motherName;
    }

    public String toString() {
        return "Student Info: " + "name: " + this.name
                + ", age: " + this.age
                + ", rollNumber: " + this.rollNumber
                + ", fatheName: " + this.fatherName
                + ", motherName: " + this.motherName
                + ", subjects: " + this.subjects;
    }
}

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Director directorObj1 = new Director(new EngineeringStudent());
        Student engineeringStudent = directorObj1.createEngineeringStudent();
        System.out.println(engineeringStudent.toString());

        Director directorObj2 = new Director(new MbaStudent());
        Student mbaStudent = directorObj2.createMbaStudent();
        System.out.println(mbaStudent.toString());
    }
}
