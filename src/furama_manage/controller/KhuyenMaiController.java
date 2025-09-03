package furama_manage.controller;

import furama_manage.service.KhuyenMaiService;
import java.util.Scanner;

public class KhuyenMaiController {
    private final KhuyenMaiService khuyenMaiService = new KhuyenMaiService();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int choice;
        do {
            System.out.println("\n---- Promotion Management ----");
            System.out.println("1. Hiển thị danh sách khách hàng sử dụng dịch vụ");
            System.out.println("2. Hiển thị danh sách khách hàng nhận khuyến mãi");
            System.out.println("3. Return main menu");
            System.out.print("Choose: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        khuyenMaiService.displayCustomersUseService();
                        break;
                    case 2:
                        khuyenMaiService.displayCustomersGetVoucher();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Nhập lại");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: nhập số nguyên!");
            }
        } while (true);
    }
}
