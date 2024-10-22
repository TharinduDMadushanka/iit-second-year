package ex02;

public class Student extends Person {

    private int idNumber;
    private double fee;
    private int grade;

    public Student() {}

    public Student(String name, int myAge, String myGender, int idNumber) {
        super(name, myAge, myGender);
        this.idNumber = idNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{ " + super.toString()+
                "idNumber=" + idNumber +
                ", fee=" + fee +
                ", grade=" + grade +
                '}';
    }
}
