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

// Single Inheritance: Faculty inherits from UniversalData
class Faculty extends UniversalData {
    String subject;

    public Faculty(String name, long phoneNo, int age, String subject) {
        super(name, phoneNo, age);
        this.subject = subject;
    }

    public void displayFacultyDetails() {
        displayDetails();
        System.out.println("Subject: " + subject);
    }
}

public class Inheritance {
    public static void main(String[] args) {

        // Demonstrating Single Inheritance
        System.out.println("--- Single Inheritance ---");
        Faculty faculty = new Faculty("Dr. Smith", 9876543210L, 45, "Mathematics");

        faculty.displayDetails();
    }
}
