package ss5_method.bai_tap.bai_1;

public class TestCircle {
    private double radius = 1.0;
    private String color = "red";

    public TestCircle() {
    }

    public TestCircle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
