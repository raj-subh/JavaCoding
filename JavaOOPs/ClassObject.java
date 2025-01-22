package JavaOOPs;

class Student {
    // data members
    int studentID;
    String studentName;
    String studentCity;

    // member functions
    public void study() {
        System.out.println(studentName + " is studying.");
    }

    public void showDetails() {
        System.out.println("My Name is: " + studentName);
        System.out.println("My ID is: " + studentID);
        System.out.println("My City is: " + studentCity);
    }
}

public class ClassObject {
    public static void main(String[] args) {

        Student student1 = new Student();

        student1.studentID = 248;
        student1.studentName = "Subhash";
        student1.studentCity = "Banka";

        student1.study();
        student1.showDetails();
    }
}
