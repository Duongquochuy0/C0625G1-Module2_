package ss7_abtract_interface.bai_tap.bai_1;

public class Rectangle extends Shape implements Resizeable {
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
    public void resize(double percent) {
        width += width * percent / 100;
        height += height * percent / 100;
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + width + ", height=" + height + ", area=" + getArea() + "}";
    }
}


