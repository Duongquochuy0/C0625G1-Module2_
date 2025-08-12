package ss7_abtract_interface.bai_tap.bai_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Square(3);
        for (Resizeable shape : shapes) {
            shape.resize(50);
        }
        System.out.println(Arrays.toString(shapes));
    }
}
