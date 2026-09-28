public class Circle extends Shape {
    private double radius;
    public static final double PHI = 3.14159265358979;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return PHI * radius * radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Circle colored " + getColor() + ", area = " + calculateArea());
    }
}
