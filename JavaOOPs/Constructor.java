package JavaOOPs;

class Student {
    int rollNo;
    String name;
    String gfName;

    // creating default constructor
    Student() {
        System.out.println("This is non-parameterized constructor.");
    }

    // creating parameterized constructor for this class
    Student(int rollNo, String name, String gfName) {
        System.out.println("This is parameterized constructor.");
        this.rollNo = rollNo;
        this.name = name;
        this.gfName = gfName;
    }

    public void showDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name is: " + name);
        System.out.println("GF Name is: " + gfName);
    }
}

public class Constructor {
    public static void main(String[] args) {

        Student student = new Student(248, "Subhash", "Ankita");

        student.showDetails();
    }
}
