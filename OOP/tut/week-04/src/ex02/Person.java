package ex02;

public class Person {

    protected String name;
    protected int myAge;
    protected String myGender;

    public Person() {
    }

    public Person(String name, int myAge, String myGender) {
        this.name = name;
        this.myAge = myAge;
        this.myGender = myGender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }

    public String getMyGender() {
        return myGender;
    }

    public void setMyGender(String myGender) {
        this.myGender = myGender;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", myAge=" + myAge +
                ", myGender='" + myGender;
    }
}
