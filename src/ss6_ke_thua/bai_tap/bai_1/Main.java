package ss6_ke_thua.bai_tap.bai_1;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3.5, "red");
        System.out.println("Circle:");
        System.out.println(circle);
        Cylinder cylinder = new Cylinder(3.5, "blue", 5.0);
        System.out.println("Cylinder:");
        System.out.println(cylinder);
    }
}
