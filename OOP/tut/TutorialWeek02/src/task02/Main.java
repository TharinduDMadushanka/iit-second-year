package task02;

public class Main {
    public static void main(String[] args) {

        Circle circle1 = new Circle();

        System.out.println("The circle 1 has radius of " + circle1.getRadius() + " and area of " + circle1.getArea());

        Circle circle2 = new Circle(8);
        System.out.println("The circle 2 has radius of " + circle2.getRadius() + " and area of " + circle2.getArea());


        Circle circle3 = new Circle("Red",7);
        System.out.println("The circle 3 "+circle3.getColor() + " color & has radius of " + circle2.getRadius() + " and area of " + circle2.getArea());

//        System.out.println(circle1.setRadius(20));
        System.out.println(circle3.toString());
        System.out.println(circle3);
    }
}