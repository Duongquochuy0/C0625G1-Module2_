package furama_manage.controller;

import furama_manage.entity.NhanVien;
import furama_manage.service.NhanVienService;

import java.util.List;
import java.util.Scanner;

public class NhanVienController {
    private final Scanner scanner = new Scanner(System.in);
    private NhanVienService nhanVienService = new NhanVienService();
    public void menu(){
        while (true){
            System.out.println("---- Quản Lý Nhân Viên ----");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm nhân viên mới");
            System.out.println("3. Chỉnh sửa thông tin nhân viên");
            System.out.println("4. Quay lại menu chính");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Danh sách nhân viên");
                        List<NhanVien> nhanViens = nhanVienService.displayAllNhanVien();
                        for(NhanVien nhanVien: nhanViens){
                            System.out.println(nhanVien);
                        }
                        break;
                    case 2:
                        System.out.println("Thêm nhân viên");
                        nhanVienService.addEmployee();
                        break;
                    case 3:
                        System.out.println("Sửa thông tin nhân viên");
                        nhanVienService.editEmployee();
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
