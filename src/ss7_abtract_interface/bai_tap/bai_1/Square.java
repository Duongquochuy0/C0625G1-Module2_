package ss7_abtract_interface.bai_tap.bai_1;

public class Square extends Shape implements Resizeable {
    private double side;

    public Square(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void resize(double percent) {
        side += side * percent / 100;
    }

    @Override
    public String toString() {
        return "Square{side=" + side + ", area=" + getArea() + "}";
    }
}
