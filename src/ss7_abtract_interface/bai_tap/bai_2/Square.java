package ss7_abtract_interface.bai_tap.bai_2;

public class Square extends Shape implements Colorable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void howToColor() {
        System.out.println("Đây là màu của hình vuông");
    }
}
