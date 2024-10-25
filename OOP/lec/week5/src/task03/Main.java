package task03;

public class Main extends Exception{
    public static void main(String[] args) {

        try {
            performOperator();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void performOperator() throws Exception{

        boolean fail = true;

        if (fail){
            throw new Exception("Hello");
        }
        System.out.println("Programme failed");
    }
}