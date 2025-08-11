package ss6_ke_thua.bai_tap.bai_3;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        System.out.println("Point ban đầu: " + p1);
        p1.setXY(5, 7);
        System.out.println("Point sau khi setXY: " + p1);
        MoveablePoint mp1 = new MoveablePoint(1, 1, 0.5f, 1.0f);
        System.out.println("MoveablePoint ban đầu: " + mp1);
        mp1.move();
        System.out.println("MoveablePoint sau khi move 1 lần: " + mp1);
    }
}
