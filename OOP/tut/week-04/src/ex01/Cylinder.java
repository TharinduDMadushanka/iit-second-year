package ex01;

public class Cylinder extends Circle{

    private double height;

    public Cylinder(){}

    public Cylinder(double height){
        this.height = height;
    }

    public Cylinder(double radius, double height){
        super(radius);
        this.height = 1.0;
    }

    public Cylinder(double radius, double height, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        double volume = getArea() * height;
        return volume;
    }

    /**
        Given an error
     */

//    @Override
//    public double getArea() {
//        return getArea();
//    }

    @Override
    public double getArea() {
        return super.getArea();
    }
}
