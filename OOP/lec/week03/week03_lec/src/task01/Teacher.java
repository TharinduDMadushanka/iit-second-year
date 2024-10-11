package task01;

import task01.Person;

public class Teacher extends Person {

    private double salary;

    public Teacher(){}

    public Teacher(String name, int age, String email, double salary) {
        super(name, age, email);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
