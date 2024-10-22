package ex02;

public class Teacher extends Person {

    private double salary;
    private String subject;

    public Teacher(){}

    public Teacher(String name, int myAge , String myGender, double salary, String subject){
        super(name, myAge, myGender);
        this.salary = salary;
        this.subject = subject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "salary=" + salary +
                ", subject='" + subject + '\'' +
                '}';
    }
}
