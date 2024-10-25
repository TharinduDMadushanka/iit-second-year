package task04;

public class Main{
    public static void main(String[] args) {

        InvalidAgeException a = new InvalidAgeException();

        try {
            a.calcAge();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
