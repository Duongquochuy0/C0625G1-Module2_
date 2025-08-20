package ss15_exception_debug.bai_tap;

public class Triangle {
    private double a;
    private double b;
    private double c;
    public Triangle(double a, double b, double c) throws IllegalTriangleException {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Cạnh tam giác phải > 0");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng 2 cạnh không lớn hơn cạnh còn lại");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
