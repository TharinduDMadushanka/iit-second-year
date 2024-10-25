package task01;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5};

        int a = 30, b = 0;

        try {
            System.out.println("Accessing the element at index 5+ "+ numbers[5]);
            int c = a/b;
            System.out.println ("Result = " + c);

        }catch (ArrayIndexOutOfBoundsException | ArithmeticException e){
            System.out.println(e.getMessage());

        }

    }
}