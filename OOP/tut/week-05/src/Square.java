public class Square extends GeometricObject {

    protected double side;

    public Square() {}

    public Square(double side) {
        this.side = side;
    }

    public Square(boolean filled, String color, double side) {
        super(filled, color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side + side;
    }

    @Override
    public String getShape() {
        return "Square";
    }

}
