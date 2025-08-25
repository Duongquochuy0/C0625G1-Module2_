package ss19_string_regex.bai_tap.bai_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần kiểm tra: ");
        String number = sc.nextLine();
        if(ValidateNumberPhone.checkNumberPhone(number)){
            System.out.println("Số điện thoại hợp lệ");
        }else {
            System.out.println("Số điện thoại không hợp lệ");
        }
    }
}
