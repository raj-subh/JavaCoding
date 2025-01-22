package JavaOOPs.JavaInheritance;

// Base class: UniversalData (used across all types of inheritance)
class UniversalData {
    String name;
    long phoneNo;
    int age;

    // Constructor for UniversalData
    public UniversalData(String name, long phoneNo, int age) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.age = age;
    }

    // Method to display universal details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Phone No: " + phoneNo);
        System.out.println("Age: " + age);
    }
}

// Hierarchical Inheritance: Student inherits from UniversalData
class Student extends UniversalData {
    String course;

    public Student(String name, long phoneNo, int age, String course) {
        super(name, phoneNo, age);
        this.course = course;
    }

    public void displayStudentDetails() {
        displayDetails();
        System.out.println("Course: " + course);
    }
}

public class Inheritance2 {
    public static void main(String[] args) {

        // Demonstrating Hierarchical Inheritance
        System.out.println("\n--- Hierarchical Inheritance ---");

        Student student = new Student("Alice", 9876543230L, 20, "Computer Science");

        student.displayStudentDetails();
    }
}
