package ss7_abtract_interface.bai_tap.bai_1;
public class Circle extends Shape implements Resizeable{
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public void resize(double percent) {
        radius += radius * percent / 100;
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + ", area=" + getArea() + "}";
    }
}


