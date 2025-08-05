package ss3_mang.bai_tap;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;

        System.out.print("Nhập phần tử muốn chèn: ");
        int x = sc.nextInt();

        System.out.print("Nhập vị trí muốn chèn " + x + " vào mảng: ");
        int index = sc.nextInt();
        if (index < 0 || index > n - 1) {
            System.out.println("Không chèn được phần tử vào mảng.");
        } else {
            for (int i = n - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = x;
            System.out.println("Mảng sau khi chèn:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
}
