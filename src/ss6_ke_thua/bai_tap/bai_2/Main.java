package ss6_ke_thua.bai_tap.bai_2;

public class Main {
    public static void main(String[] args) {
        Point2D p2 = new Point2D(1.5f, 2.5f);
        System.out.println("Point2D: " + p2);
        float[] arr2 = p2.getXY();
        System.out.println("getXY(): [" + arr2[0] + ", " + arr2[1] + "]");
        Point3D p3 = new Point3D(3.0f, 4.0f, 5.0f);
        System.out.println("Point3D: " + p3);
        float[] arr3 = p3.getXYZ();
        System.out.println("getXYZ(): [" + arr3[0] + ", " + arr3[1] + ", " + arr3[2] + "]");
        p2.setXY(10.0f, 20.0f);
        p3.setXYZ(7.0f, 8.0f, 9.0f);
        System.out.println("Sau khi setXY: " + p2);
        System.out.println("Sau khi setXYZ: " + p3);
    }
}
