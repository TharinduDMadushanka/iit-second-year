package task01;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();

        student.setName("Tharindu");
        student.setAge(22);
        student.setEmail("s@gmail.com");
        student.setIdNumber("S001");

        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Email: " + student.getEmail());
        System.out.println("Student ID: " + student.getIdNumber());

        System.out.println("=========================");

        Teacher t = new Teacher();

        t.setName("Saman");
        t.setAge(42);
        t.setEmail("t@gmail.com");
        t.setSalary(50000);

        System.out.println("Teacher Name: " + t.getName());
        System.out.println("Teacher Age: " + t.getAge());
        System.out.println("Teacher Email: " + t.getEmail());
        System.out.println("Teacher Salary: " + t.getSalary());
    }
}