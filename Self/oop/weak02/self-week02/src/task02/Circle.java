package task02;


public class Circle {

    private String color;
    private double radius;

    public Circle() {
        this.color = "blue";
        this.radius = 1;
    }

    public Circle(double r){
        radius = r;
        color = "blue";
    }

    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color='" + color + '\'' +
                ", radius=" + radius +
                '}';
    }
}
