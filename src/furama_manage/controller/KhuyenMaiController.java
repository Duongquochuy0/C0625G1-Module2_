//package furama_manage.controller;
//
//import furama_manage.service.KhuyenMaiService;
//import java.util.Scanner;
//
//public class KhuyenMaiController {
//    private final Scanner scanner = new Scanner(System.in);
//    private final KhuyenMaiService khuyenMaiService = new KhuyenMaiService();
//
//    public void menu() {
//        while (true) {
//            System.out.println("---- Quản Lý Khuyến Mãi ----");
//            System.out.println("1. Hiển thị danh sách khách hàng sử dụng dịch vụ");
//            System.out.println("2. Hiển thị danh sách khách hàng nhận được khuyến mãi");
//            System.out.println("3. Quay lại menu chính");
//            try {
//                int choice = Integer.parseInt(scanner.nextLine());
//                switch (choice) {
//                    case 1:
//                        khuyenMaiService.displayCustomersByYear();
//                        break;
//                    case 2:
//                        khuyenMaiService.giveVouchers();
//                        break;
//                    case 3:
//                        return;
//                    default:
//                        System.err.println("Lựa chọn không hợp lệ");
//                        break;
//                }
//            } catch (NumberFormatException e) {
//                System.err.println("Dữ liệu đầu vào không hợp lệ");
//            }
//        }
//    }
//}
