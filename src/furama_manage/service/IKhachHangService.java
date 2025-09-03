package furama_manage.service;

import furama_manage.entity.KhachHang;

import java.util.List;

public interface IKhachHangService {
    List<KhachHang> displayAllCustomer();
    boolean addCustomer();
    void editCustomer();
}
