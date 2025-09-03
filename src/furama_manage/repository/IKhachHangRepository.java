package furama_manage.repository;

import furama_manage.entity.KhachHang;

import java.util.List;

public interface IKhachHangRepository {
    List<KhachHang> getAllCustomer();
    boolean addCustomer(KhachHang khachHang);
    void editCustomer(KhachHang khachHang);
}
