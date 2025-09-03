package furama_manage.entity;

public class House extends CoSoVatChat {
    private String tieuChuanPhong;
    private int soTang;

    public House() {
    }

    public House(String maDichVu, String tenDichVu, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue, String tieuChuanPhong, int soTang) {
        super(maDichVu, tenDichVu, dienTich, chiPhi, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.soTang = soTang;
    }

    public House(String tieuChuanPhong, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "--- Thông tin nhà ---\n" +
                super.toString() + "\n" +
                "Tiêu chuẩn phòng: " + tieuChuanPhong + "\n" +
                "Số tầng: " + soTang + "\n";
    }
}
