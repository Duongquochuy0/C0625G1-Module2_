package furama_manage.view;
import furama_manage.entity.NhanVien;
import furama_manage.util.UserInputException;
import furama_manage.util.Validating;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class NhanVienView {
    private static Scanner scanner = new Scanner(System.in);
    public static void disPlay(List<NhanVien> nhanVienList){
        for (NhanVien nhanVien: nhanVienList) {
            System.out.println(nhanVien);
        }
    }
    public static NhanVien nhapNhanVien(){
        String id;
        String hoTen;
        LocalDate ngaySinh = null;
        String gioiTinh;
        String chungMinhNhanDan;
        String soDienThoai;
        String email;
        String trinhDo;
        String viTri;
        Double luong = null;

        while (true) {
            try {
                System.out.println("Nhập Mã nhân viên (NV-YYYY):");
                id = scanner.nextLine();
                Validating.validateEmployeeId(id);
                break;
            } catch (UserInputException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Nhập Họ tên:");
                hoTen = scanner.nextLine();
                Validating.validateName(hoTen);
                break;
            } catch (UserInputException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Nhập Ngày sinh (YYYY-MM-DD):");
                ngaySinh = LocalDate.parse(scanner.nextLine());
                Validating.validateAge(ngaySinh);
                break;
            } catch (UserInputException | DateTimeParseException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Nhập Giới tính :");
                gioiTinh = scanner.nextLine();
                Validating.validateGender(gioiTinh);
                break;
            } catch (UserInputException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Nhập Số CMND :");
                chungMinhNhanDan = scanner.nextLine();
                Validating.validateIdCard(chungMinhNhanDan);
                break;
            } catch (UserInputException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Nhập Số điện thoại:");
                soDienThoai = scanner.nextLine();
                Validating.validatePhoneNumber(soDienThoai);
                break;
            } catch (UserInputException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Nhập Email:");
                email = scanner.nextLine();
                Validating.validateEmail(email);
                break;
            } catch (UserInputException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        System.out.println("Nhập Trình độ:");
        trinhDo = scanner.nextLine();
        System.out.println("Nhập Vị trí:");
        viTri = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Nhập Lương:");
                luong = Double.parseDouble(scanner.nextLine());
                Validating.validateSalary(luong);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        NhanVien nhanVien =new NhanVien(id, hoTen, ngaySinh, gioiTinh, chungMinhNhanDan, soDienThoai, email, trinhDo, viTri, luong);
        return nhanVien;
    }
}