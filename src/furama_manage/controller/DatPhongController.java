package furama_manage.controller;

import java.util.Scanner;

public class DatPhongController {
    private final Scanner scanner= new Scanner(System.in);
    public void menu() {
        while (true) {
            System.out.println("---- Quản Lý Đặt Phòng ----");
            System.out.println("1. Đặt phòng mới");
            System.out.println("2. Hiển thị danh sách đặt phòng");
            System.out.println("3. Tạo hợp đồng mới");
            System.out.println("4. Hiển thị danh sách hợp đồng");
            System.out.println("5. Chỉnh sửa hợp đồng");
            System.out.println("6. Quay lại menu chính");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Đặt phòng mới");
                        break;
                    case 2:
                        System.out.println("Hiển thị danh sách đặt phòng");
                        break;
                    case 3:
                        System.out.println("Tạo hợp đồng mới");
                        break;
                    case 4:
                        System.out.println("Hiển thị danh sách hợp đồng");
                        break;
                    case 5:
                        System.err.println("Chỉnh sửa hợp đồng");
                        break;
                    case 6:
                        return;
                }
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu đầu vào không hợp lệ");
            }
        }
    }
}