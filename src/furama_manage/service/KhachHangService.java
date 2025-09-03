package furama_manage.service;

import furama_manage.entity.KhachHang;
import furama_manage.entity.NhanVien;
import furama_manage.repository.IKhachHangRepository;
import furama_manage.repository.KhachHangRepository;
import furama_manage.util.UserInputException;
import furama_manage.util.Validating;
import furama_manage.view.KhachHangView;
import furama_manage.view.NhanVienView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class KhachHangService implements IKhachHangService {
    private IKhachHangRepository khachHangRepository = new KhachHangRepository();
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public List<KhachHang> displayAllCustomer() {
        return khachHangRepository.getAllCustomer();
    }

    @Override
    public boolean addCustomer() {
        KhachHang newKhachHang = KhachHangView.nhapKhachHang();
        if (khachHangRepository.addCustomer(newKhachHang)) {
            System.out.println("Thêm nhân viên mới thành công.");
            return true;
        } else {
            System.out.println("Thêm nhân viên thất bại.");
            return false;
        }
    }

    @Override
    public void editCustomer() {
        while (true) {
            System.out.println("Nhập ID khách hàng cần sửa:");
            String customerId = scanner.nextLine();
            List<KhachHang> khachHangList = khachHangRepository.getAllCustomer();
            KhachHang khachHangToEdit = null;
            for (KhachHang khachHang : khachHangList) {
                if (khachHang.getId().equals(customerId)) {
                    khachHangToEdit = khachHang;
                    break;
                }
            }

            if (khachHangToEdit != null) {
                System.out.println("Đang sửa thông tin cho khách hàng: " + khachHangToEdit.getId() + " - " + khachHangToEdit.getHoTen());

                while (true) {
                    try {
                        System.out.println("Nhập Họ tên mới:");
                        String hoTen = scanner.nextLine();
                        if (!hoTen.isEmpty()) {
                            Validating.validateName(hoTen);
                            khachHangToEdit.setHoTen(hoTen);
                        }
                        break;
                    } catch (UserInputException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Nhập Ngày sinh mới (YYYY-MM-DD):");
                        String ngaySinhStr = scanner.nextLine();
                        if (!ngaySinhStr.isEmpty()) {
                            LocalDate ngaySinh = LocalDate.parse(ngaySinhStr);
                            Validating.validateAge(ngaySinh);
                            khachHangToEdit.setNgaySinh(ngaySinh);
                        }
                        break;
                    } catch (UserInputException | DateTimeParseException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.println("Nhập Giới tính mới (Male, Female):");
                        String gioiTinh = scanner.nextLine();
                        if (!gioiTinh.isEmpty()) {
                            Validating.validateGender(gioiTinh);
                            khachHangToEdit.setGioiTinh(gioiTinh);
                        }
                        break;
                    } catch (UserInputException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Nhập Số CMND mới (9 hoặc 12 số):");
                        String cmnd = scanner.nextLine();
                        if (!cmnd.isEmpty()) {
                            Validating.validateIdCard(cmnd);
                            khachHangToEdit.setChungMinhNhanDan(cmnd);
                        }
                        break;
                    } catch (UserInputException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Nhập Số điện thoại mới:");
                        String soDienThoai = scanner.nextLine();
                        if (!soDienThoai.isEmpty()) {
                            Validating.validatePhoneNumber(soDienThoai);
                            khachHangToEdit.setSoDienThoai(soDienThoai);
                        }
                        break;
                    } catch (UserInputException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Nhập Email mới:");
                        String email = scanner.nextLine();
                        if (!email.isEmpty()) {
                            Validating.validateEmail(email);
                            khachHangToEdit.setEmail(email);
                        }
                        break;
                    } catch (UserInputException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }

                System.out.println("Nhập Loại khách mới (Diamond, Platinium, Gold, Silver, Member):");
                String loaiKhach = scanner.nextLine();
                if (!loaiKhach.isEmpty()) {
                    khachHangToEdit.setLoaiKhach(loaiKhach);
                }

                System.out.println("Nhập Địa chỉ mới:");
                String diaChi = scanner.nextLine();
                if (!diaChi.isEmpty()) {
                    khachHangToEdit.setDiaChi(diaChi);
                }

                khachHangRepository.editCustomer(khachHangToEdit);
                System.out.println("Cập nhật thông tin khách hàng thành công");
                break;
            } else {
                System.err.println("Không tìm thấy khách hàng có ID: " + customerId);
                System.out.println("Vui lòng nhập lại");
            }
        }
    }
}
