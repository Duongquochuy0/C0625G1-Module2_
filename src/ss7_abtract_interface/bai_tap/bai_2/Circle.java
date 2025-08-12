package ss7_abtract_interface.bai_tap.bai_2;

public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }


    @Override
    public String toString() {
        return "Circle{radius=" + radius + ", area=" + getArea() + "}";
    }
}
