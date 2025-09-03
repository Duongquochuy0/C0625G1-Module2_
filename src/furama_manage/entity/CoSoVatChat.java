package furama_manage.entity;

public abstract class CoSoVatChat {
    private String maDichVu;
    private String tenDichVu;
    private double dienTich;
    private double chiPhi;
    private int soLuongNguoi;
    private String kieuThue;

    public CoSoVatChat() {
    }

    public CoSoVatChat(String maDichVu, String tenDichVu, double dienTich, double chiPhi, int soLuongNguoi, String kieuThue) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhi = chiPhi;
        this.soLuongNguoi = soLuongNguoi;
        this.kieuThue = kieuThue;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    @Override
    public String toString() {
        return "Mã dịch vụ: " + maDichVu + "\n" +
                "Tên dịch vụ: " + tenDichVu + "\n" +
                "Diện tích: " + dienTich + "\n" +
                "Chi phí: " + chiPhi + "\n" +
                "Số lượng người thuê: " + soLuongNguoi + "\n" +
                "Kiểu thuê: " + kieuThue;
    }
}
