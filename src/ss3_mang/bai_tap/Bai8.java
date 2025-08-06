package ss3_mang.bai_tap;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "Duong Quoc Huy";
        System.out.println("Nhập ký tự muốn kiểm tra:");
        String a = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (a.charAt(0) == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện "+ a +" là " + count);
    }
}
