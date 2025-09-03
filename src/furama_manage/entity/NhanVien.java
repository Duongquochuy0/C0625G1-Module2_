package furama_manage.entity;

import java.time.LocalDate;

public class NhanVien extends ConNguoi {
    private String trinhDo;
    private String viTri;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String id, String hoTen, LocalDate ngaySinh, String gioiTinh, String chungMinhNhanDan, String soDienThoai, String email, String trinhDo, String viTri, double luong) {
        super(id, hoTen, ngaySinh, gioiTinh, chungMinhNhanDan, soDienThoai, email);
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "--- Thông tin nhân viên ---\n" +
                super.toString() + "\n" +
                "Trình độ: " + trinhDo + "\n" +
                "Vị trí: " + viTri + "\n" +
                "Lương: " + luong + "\n";
    }
//    String id, String hoTen, LocalDate ngaySinh, String gioiTinh, String chungMinhNhanDan, String soDienThoai, String email, String trinhDo, String viTri, double luong

    public String getInfoToCSV(){
        return this.getId()+","+this.getHoTen()+","+this.getNgaySinh()+","+this.getGioiTinh()+","+this.getChungMinhNhanDan()+","+this.getSoDienThoai()+","+this.getEmail()+","+this.getTrinhDo()+","+this.getViTri()+","+this.getLuong();
    }
}
