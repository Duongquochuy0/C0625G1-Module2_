package furama_manage.controller;

import furama_manage.entity.KhachHang;
import furama_manage.entity.NhanVien;
import furama_manage.service.KhachHangService;
import furama_manage.service.NhanVienService;

import java.util.List;
import java.util.Scanner;

public class KhachHangController {
    private final Scanner scanner = new Scanner(System.in);
    private KhachHangService khachHangService = new KhachHangService();
    public void menu() {
        while (true) {
            System.out.println("---- Quản Lý Khách Hàng ----");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm khách hàng mới");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Quay lại menu chính");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Danh sách khách hàng");
                        List<KhachHang> khachHangs = khachHangService.displayAllCustomer();
                        for(KhachHang khachHang: khachHangs){
                            System.out.println(khachHang);
                        }
                        break;
                    case 2:
                        System.out.println("Thêm khách hàng");
                        khachHangService.addCustomer();
                        break;
                    case 3:
                        System.out.println("Sửa thông tin khách hàng");
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println("Lựa chọn không hợp lệ");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu đầu vào không hợp lệ");
            }
        }
    }
}