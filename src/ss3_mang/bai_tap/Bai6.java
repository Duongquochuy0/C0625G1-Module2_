package ss3_mang.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số hàng của mảng:");
        int row = sc.nextInt();
        System.out.println("Nhập số cột của mảng:");
        int colum = sc.nextInt();
        int[][] matrix = new int[row][colum];
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Mảng 2 chiều bạn đã nhập:");
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("Nhập cột bạn muốn tính tổng:");
        int choice = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += matrix[i][choice];
        }

        System.out.println("Tổng các phần tử ở cột " + choice + " là: " + sum);
    }
}
