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

// Multilevel Inheritance: ResearchFaculty inherits from Faculty
class ResearchFaculty extends Faculty {
    String researchTopics;

    public ResearchFaculty(String name, long phoneNo, int age, String subject, String researchTopic) {
        super(name, phoneNo, age, subject);
        this.researchTopics = researchTopic;
    }

    public void displayResearchFacultyDetails() {
        displayFacultyDetails();
        System.out.println("Research Topic: " + researchTopics);
    }
}

public class Inheritance1 {
    public static void main(String[] args) {

        // Demonstrating Multilevel Inheritance
        System.out.println("\n--- Multilevel Inheritance ---");

        ResearchFaculty researchFaculty = new ResearchFaculty("Dr. Jane", 9876543220L, 50, "Physics",
                "Quantum Mechanics");

        researchFaculty.displayResearchFacultyDetails();
    }
}
