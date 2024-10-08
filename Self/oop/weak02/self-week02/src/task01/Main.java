package task01;

//Q 1 to 7

public class Main {
    public static void main(String[] args) {

        Person p = new Person("Ben");
        p.displayName();

        System.out.println("=================================");

        Person p2 = new Person("Shanka");
        p2.setSurname("TDM");
        p2.setAge(22);
        p2.displayName();
        System.out.println("Surname: " + p2.getSurname());
        System.out.println("Age: " + p2.getAge());
    }
}