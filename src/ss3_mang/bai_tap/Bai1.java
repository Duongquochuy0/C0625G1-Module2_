package ss3_mang.bai_tap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập phần tử muốn xóa: ");
        int x = sc.nextInt();

        int index_del = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                index_del = i;
                break;
            }
        }

        if (index_del == -1) {
            System.out.println("Phần tử " + x + " không xuất hiện trong mảng.");
        } else {
            for (int i = index_del; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = 0;

            System.out.println("Mảng sau khi xóa phần tử " + x + ":");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
