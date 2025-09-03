package furama_manage.view;

import furama_manage.entity.KhachHang;
import furama_manage.util.UserInputException;
import furama_manage.util.Validating;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class KhachHangView {
    private static final Scanner scanner = new Scanner(System.in);
    public static void disPlay(List<KhachHang> khachHangList){
        for (KhachHang khachHang: khachHangList) {
            System.out.println(khachHangList);
        }
    }
    public static KhachHang nhapKhachHang(){
        String id;
        String hoTen;
        LocalDate ngaySinh = null;
        String gioiTinh;
        String chungMinhNhanDan;
        String soDienThoai;
        String email;
        String kieuKhachHang;
        String diaChi;
        while (true) {
            try {
                System.out.println("Nhập Mã khách hàng (KH-YYYY):");
                id = scanner.nextLine();
                Validating.validateCustumerId(id);
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
        while (true){
            try{
                System.out.println("Nhập kiểu khách hàng: ");
                kieuKhachHang =scanner.nextLine();
                Validating.validateCustomerType(kieuKhachHang);
                break;
            }catch (UserInputException e){
                System.err.println("Lỗi: "+e.getMessage());
            }
        }
        System.out.println("Nhập địa chỉ khách hàng");
        diaChi=scanner.nextLine();
        KhachHang khachHang =new KhachHang(id, hoTen, ngaySinh, gioiTinh, chungMinhNhanDan, soDienThoai, email, kieuKhachHang,diaChi);
        return khachHang;
    }
}
