package ss5_method.bai_tap.bai_1;

public class Main {
    public static void main(String[] args) {
        TestCircle circle1 = new TestCircle();
        System.out.println("Bán kính: " + circle1.getRadius());
        System.out.println("Diện tích: " + circle1.getArea());
        TestCircle circle2 = new TestCircle(5);
        System.out.println("Bán kính: " + circle2.getRadius());
        System.out.println("Diện tích: " + circle2.getArea());
    }
}
