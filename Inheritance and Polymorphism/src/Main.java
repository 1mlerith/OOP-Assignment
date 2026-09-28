public class Main {
    public static void main(String[] args) {
        // Demonstrating Inheritance and Polymorphism
        Shape shape = new Shape("Red");
        Square square = new Square(5, "Blue");
        Circle circle = new Circle(7, "Green");
        Cylinder cylinder = new Cylinder(10, 7, "Yellow");

        // Polymorphism: calling printInfo() on Shape type
        System.out.println("=== Polymorphism Demo ===");
        Shape[] shapes = {shape, square, circle, cylinder};
        for (Shape s : shapes) {
            s.printInfo();
        }

        // Details of each object
        System.out.println("\n=== Square Details ===");
        System.out.println("Side: " + square.getSide());
        System.out.println("Area: " + square.calculateArea());

        System.out.println("\n=== Circle Details ===");
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.calculateArea());

        System.out.println("\n=== Cylinder Details ===");
        System.out.println("Height: " + cylinder.getHeight());
        System.out.println("Radius: " + cylinder.getRadius());
        System.out.println("Volume: " + cylinder.calculateVolume());
    }
}
