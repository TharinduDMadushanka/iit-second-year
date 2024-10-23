public class Main {
    public static void main(String[] args) {

        ShapeCollection sys = new GeometricShapeCollection(10);
        boolean exit = false;

        while (!exit) {
            exit=sys.runMenu();
        }
    }
}