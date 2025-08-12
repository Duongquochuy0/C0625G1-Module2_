package ss7_abtract_interface.bai_tap.bai_2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(5);
        shapes[1] = new Circle(3);
        shapes[2] = new Rectangle(4, 6);

        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.getArea());

            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
