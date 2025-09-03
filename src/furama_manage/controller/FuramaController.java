package furama_manage.controller;

import furama_manage.service.NhanVienService;

import java.util.Scanner;

public class FuramaController {
    private static final Scanner scanner = new Scanner(System.in);
    private NhanVienService nhanVienService = new NhanVienService();
    public void displayMainMenu() {
        while (true) {
            System.out.println("----- FURAMA RESORT MANAGEMENT -----");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Quản lý cơ sở");
            System.out.println("4. Quản lý đặt phòng");
            System.out.println("5. Quản lý khuyến mãi");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        NhanVienController nhanVienController = new NhanVienController();
                        nhanVienController.menu();
                        break;
                    case 2:
                        KhachHangController khachHangController= new KhachHangController();
                        khachHangController.menu();
                        break;
                    case 3:
                        CoSoVatChatController coSoVatChatController= new CoSoVatChatController();
                        coSoVatChatController.menu();
                        break;
                    case 4:
                        BookingController bookingController =new BookingController();
                        bookingController.menu();
                        break;
                    case 5:
//                        KhuyenMaiController khuyenMaiController= new KhuyenMaiController();
//                        khuyenMaiController.menu();
                        break;
                    case 6:
                        System.out.println("Kết thúc chương trình");
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
