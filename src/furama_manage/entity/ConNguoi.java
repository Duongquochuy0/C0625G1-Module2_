package furama_manage.entity;

import java.time.LocalDate;

public abstract class ConNguoi {
    private String id;
    private String hoTen;
    private LocalDate ngaySinh;
    private String gioiTinh;
    private String chungMinhNhanDan;
    private String soDienThoai;
    private String email;

    public ConNguoi() {
    }

    public ConNguoi(String id, String hoTen, LocalDate ngaySinh, String gioiTinh, String chungMinhNhanDan, String soDienThoai, String email) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.chungMinhNhanDan = chungMinhNhanDan;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChungMinhNhanDan() {
        return chungMinhNhanDan;
    }

    public void setChungMinhNhanDan(String chungMinhNhanDan) {
        this.chungMinhNhanDan = chungMinhNhanDan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Mã định danh: " + id + "\n" +
                "Họ tên: " + hoTen + "\n" +
                "Ngày sinh: " + ngaySinh + "\n" +
                "Giới tính: " + gioiTinh + "\n" +
                "Số CMND: " + chungMinhNhanDan + "\n" +
                "Số điện thoại: " + soDienThoai + "\n" +
                "Email: " + email;
    }
}
