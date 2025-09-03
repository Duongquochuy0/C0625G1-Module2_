package furama_manage.entity;

import java.time.LocalDate;

public class KhachHang extends ConNguoi {
    private String loaiKhach;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String id, String hoTen, LocalDate ngaySinh, String gioiTinh, String chungMinhNhanDan, String soDienThoai, String email, String loaiKhach, String diaChi) {
        super(id, hoTen, ngaySinh, gioiTinh, chungMinhNhanDan, soDienThoai, email);
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public KhachHang(String loaiKhach, String diaChi) {
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    @Override
    public String toString() {
        return "--- Thông tin nhân viên ---\n" +
                super.toString() + "\n" +
                "Loại khách hàng: " + loaiKhach + "\n" +
                "Địa chỉ: " + diaChi + "\n" ;
    }
    public String getInfoToCSV(){
        return this.getId()+","+this.getHoTen()+","+this.getNgaySinh()+","+this.getGioiTinh()+","+this.getChungMinhNhanDan()+","+this.getSoDienThoai()+","+this.getEmail()+","+this.getLoaiKhach()+","+this.getDiaChi();
    }
}
