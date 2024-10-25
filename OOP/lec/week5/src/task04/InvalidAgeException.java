package task04;

public class InvalidAgeException extends Exception{

    public  void calcAge() throws Exception {
        int age = 125;

        if(age >120){
            throw new Exception("Age cant't be greater than 120");
        }else if(age <0){
            throw new Exception("Age cant't be less than 0");
        }
            System.out.println("Your age is " + age);

    }
}
