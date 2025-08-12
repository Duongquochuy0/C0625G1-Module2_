package ss7_abtract_interface.bai_tap.bai_2;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + width + ", height=" + height + ", area=" + getArea() + "}";
    }
}
