package furama_manage.entity;

public class KhuyenMai {
    private String idKhachHang;
    private String khuyenMai;
    public KhuyenMai() {
    }

    public KhuyenMai(String idKhachHang, String khuyenMai) {
        this.idKhachHang = idKhachHang;
        this.khuyenMai = khuyenMai;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
    @Override
    public String toString() {
        return "Voucher{" +
                "customerId='" + idKhachHang + '\'' +
                ", discount='" + khuyenMai + '\'' +
                '}';
    }
}
