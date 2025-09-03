package furama_manage.repository;

import furama_manage.entity.NhanVien;

import java.util.List;

public interface INhanVienRepository {
    List<NhanVien> getAllEmployees();
    boolean addEmployee(NhanVien nhanVien);
    void editEmployee(NhanVien nhanVien);
}
