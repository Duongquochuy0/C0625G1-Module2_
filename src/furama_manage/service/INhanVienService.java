package furama_manage.service;

import furama_manage.entity.NhanVien;

import java.util.List;

public interface INhanVienService {
    List<NhanVien> displayAllNhanVien();
    boolean addEmployee();
    void editEmployee();
}
