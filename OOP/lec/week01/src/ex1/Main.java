package ex1;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();

        s1.setName("Tharindu");
        s1.setAge(23);
        s1.setGrade(65);

        s1.displayDetails();
        s1.hasPassed(s1.getGrade());

    }
}