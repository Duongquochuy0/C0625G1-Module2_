package ss3_mang.bai_tap;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập cạnh của ma trận hình vuông: ");
        int row = sc.nextInt();
        int[][] matrix = new int[row][row];
        System.out.println("Nhập các phần tử trong mảng:");
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < row ; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Bạn muốn tính tổng đường chéo nào?");
        System.out.println("1. Đường chéo từ trái qua phải");
        System.out.println("2. Đường chéo từ phải qua trái");
        int choice = sc.nextInt();

        int sum = 0;
        if (choice == 1) {
            for (int i = 0; i < row; i++) {
                sum += matrix[i][i];
            }
            System.out.println("Tổng đường chéo từ trái qua phải là: " + sum);
        } else if (choice == 2) {
            for (int i = 0; i < row; i++) {
                sum += matrix[i][row - 1 - i];
            }
            System.out.println("Tổng đường chéo từ phải qua trái là: " + sum);
        }
    }
}
