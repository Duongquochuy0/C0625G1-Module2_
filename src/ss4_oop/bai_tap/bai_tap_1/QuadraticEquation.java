package ss4_oop.bai_tap.bai_tap_1;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double getRoot2() {
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double getRoot3() {
        return -b / (2 * a);
    }

    public double delta() {
        return getDiscriminant();
    }

    public String result() {
        if (a == 0) {
            return "This is not a quadratic equation";
        } else {
            double d = getDiscriminant();
            if (d < 0) {
                return "The equation has no real roots";
            } else if (d == 0) {
                return "x = " + getRoot3();
            } else {
                return "x1 = " + getRoot1() + "; x2 = " + getRoot2();
            }
        }
    }
}
