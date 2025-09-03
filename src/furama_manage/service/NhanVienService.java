package furama_manage.service;

import furama_manage.entity.NhanVien;
import furama_manage.repository.INhanVienRepository;
import furama_manage.repository.NhanVienRepository;
import furama_manage.util.UserInputException;
import furama_manage.util.Validating;
import furama_manage.view.NhanVienView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class NhanVienService implements INhanVienService{
    private INhanVienRepository nhanVienRepository = new NhanVienRepository();
    private static final Scanner scanner = new Scanner(System.in);
    @Override
    public List<NhanVien> displayAllNhanVien() {
        return nhanVienRepository.getAllEmployees();
    }

    @Override
    public boolean addEmployee() {
        NhanVien newNhanVien = NhanVienView.nhapNhanVien();
        if (nhanVienRepository.addEmployee(newNhanVien)) {
            System.out.println("Thêm nhân viên mới thành công.");
            return true;
        } else {
            System.out.println("Thêm nhân viên thất bại.");
            return false;
        }
    }
    @Override
    public void editEmployee() {
        while (true) {
            System.out.println("Nhập ID nhân viên cần sửa:");
            String employeeId = scanner.nextLine();
            List<NhanVien> nhanVienList = nhanVienRepository.getAllEmployees();
            NhanVien nhanVienToEdit = null;
            for (NhanVien nv : nhanVienList) {
                if (nv.getId().equals(employeeId)) {
                    nhanVienToEdit = nv;
                    break;
                }
            }
            if (nhanVienToEdit != null) {
                System.out.println("Đang sửa thông tin cho nhân viên: " + nhanVienToEdit.getId() + " - " + nhanVienToEdit.getHoTen());
                while (true) {
                    try {
                        System.out.println("Nhập Họ tên mới:");
                        String hoTen = scanner.nextLine();
                        if (!hoTen.isEmpty()) {
                            Validating.validateName(hoTen);
                            nhanVienToEdit.setHoTen(hoTen);
                        }
                        break;
                    } catch (UserInputException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Nhập Ngày sinh mới:");
                        String ngaySinhStr = scanner.nextLine();
                        if (!ngaySinhStr.isEmpty()) {
                            LocalDate ngaySinh = LocalDate.parse(ngaySinhStr);
                            Validating.validateAge(ngaySinh);
                            nhanVienToEdit.setNgaySinh(ngaySinh);
                        }
                        break;
                    } catch (UserInputException | DateTimeParseException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.println("Nhập Giới tính mới (Male, Female:");
                        String gioiTinh = scanner.nextLine();
                        if (!gioiTinh.isEmpty()) {
                            Validating.validateGender(gioiTinh);
                            nhanVienToEdit.setGioiTinh(gioiTinh);
                        }
                        break;
                    } catch (UserInputException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Nhập Số CMND mới:");
                        String cmnd = scanner.nextLine();
                        if (!cmnd.isEmpty()) {
                            Validating.validateIdCard(cmnd);
                            nhanVienToEdit.setChungMinhNhanDan(cmnd);
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
                            nhanVienToEdit.setSoDienThoai(soDienThoai);
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
                            nhanVienToEdit.setEmail(email);
                        }
                        break;
                    } catch (UserInputException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }
                System.out.println("Nhập Trình độ mới:");
                String trinhDo = scanner.nextLine();
                if (!trinhDo.isEmpty()) {
                    nhanVienToEdit.setTrinhDo(trinhDo);
                }
                System.out.println("Nhập Vị trí mới:");
                String viTri = scanner.nextLine();
                if (!viTri.isEmpty()) {
                    nhanVienToEdit.setViTri(viTri);
                }
                while (true) {
                    try {
                        System.out.println("Nhập Lương mới:");
                        String luongStr = scanner.nextLine();
                        if (!luongStr.isEmpty()) {
                            Double luong = Double.parseDouble(luongStr);
                            Validating.validateSalary(luong);
                            nhanVienToEdit.setLuong(luong);
                        }
                        break;
                    } catch (UserInputException | NumberFormatException e) {
                        System.err.println("Lỗi: " + e.getMessage());
                    }
                }
                nhanVienRepository.editEmployee(nhanVienToEdit);
                System.out.println("Cập nhật thông tin nhân viên thành công");
                break;
            } else {
                System.err.println("Không tìm thấy nhân viên có ID: " + employeeId);
                System.out.println("Vui lòng nhập lại");
            }
        }
    }
}
