package JavaOOPs.Oops4Pillars;

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
    String researchTopic;

    public ResearchFaculty(String name, long phoneNo, int age, String subject, String researchTopic) {
        super(name, phoneNo, age, subject);
        this.researchTopic = researchTopic;
    }

    public void displayResearchFacultyDetails() {
        displayFacultyDetails();
        System.out.println("Research Topic: " + researchTopic);
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

// Hybrid Inheritance (combination of hierarchical and multilevel)
class GraduateStudent extends Student {
    int graduationYear;

    public GraduateStudent(String name, long phoneNo, int age, String course, int graduationYear) {
        super(name, phoneNo, age, course);
        this.graduationYear = graduationYear;
    }

    public void displayGraduateStudentDetails() {
        displayStudentDetails();
        System.out.println("Graduation Year: " + graduationYear);
    }
}

public class allInheritance {
    public static void main(String[] args) {
        // Demonstrating Single Inheritance
        System.out.println("--- Single Inheritance ---");
        Faculty faculty = new Faculty("Dr. Smith", 9876543210L, 45, "Mathematics");
        faculty.displayFacultyDetails();

        // Demonstrating Multilevel Inheritance
        System.out.println("\n--- Multilevel Inheritance ---");
        ResearchFaculty researchFaculty = new ResearchFaculty("Dr. Jane", 9876543220L, 50, "Physics",
                "Quantum Mechanics");
        researchFaculty.displayResearchFacultyDetails();

        // Demonstrating Hierarchical Inheritance
        System.out.println("\n--- Hierarchical Inheritance ---");
        Student student = new Student("Alice", 9876543230L, 20, "Computer Science");
        student.displayStudentDetails();

        // Demonstrating Hybrid Inheritance
        System.out.println("\n--- Hybrid Inheritance ---");
        GraduateStudent graduateStudent = new GraduateStudent("Bob", 9876543240L, 23, "Information Technology", 2024);
        graduateStudent.displayGraduateStudentDetails();
    }
}
