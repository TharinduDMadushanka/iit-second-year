package task01;

import task01.Person;

public class Student extends Person {

    private String idNumber;

    public Student() {}

    public Student(String name, int age, String email, String idNumber) {
        super(name, age, email);
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
