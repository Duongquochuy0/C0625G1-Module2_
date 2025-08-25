package ss19_string_regex.bai_tap.bai_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhập tên lớp muốn kiểm tra: ");
        String stringName= scanner.nextLine();
        if(Validate.CheckNameClass(stringName)){
            System.out.println("Tên lớp hợp lệ");
        }else {
            System.out.println("Tên lớp không hợp lệ");
        }
    }
}
