package task01;

public class Person {

    private String name;
    private String surname;
    private int age;

    public Person(){}

    public Person(String n){
        name= n;
    }

    public void displayName(){
        System.out.println(name);
    }

    public void setSurname(String s){
        surname= s;
    }

    public String getSurname(){
        return surname;
    }

    public void setAge(int a){
        age= a;
    }

    public int getAge(){
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}