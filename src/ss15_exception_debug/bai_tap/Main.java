package ss15_exception_debug.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            try {
                System.out.print("Nhập cạnh thứ nhất: ");
                double a = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập cạnh thứ hai: ");
                double b = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập cạnh thứ ba: ");
                double c = Double.parseDouble(sc.nextLine());
                Triangle triangle = new Triangle(a, b, c);
                System.out.println("Đây là tam giác");
                flag = false;
            } catch (IllegalTriangleException e) {
                System.out.println("Lỗi: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi nhập dữ liệu");
            }
        }
    }
}
