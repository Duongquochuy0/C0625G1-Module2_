package ss4_oop.bai_tap.bai_tap_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a:");
        double a = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập b:");
        double b = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập c:");
        double c = Double.parseDouble(sc.nextLine());
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println(quadraticEquation.result());
    }
}
