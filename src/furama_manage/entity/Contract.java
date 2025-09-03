package furama_manage.entity;

import java.util.Objects;

public class Contract {
    private String maHopDong;
    private String maBooking;
    private String maKhachHang;
    private String maDichVu;

    public Contract(String maHopDong, String maBooking, String maKhachHang, String maDichVu) {
        this.maHopDong = maHopDong;
        this.maBooking = maBooking;
        this.maKhachHang = maKhachHang;
        this.maDichVu = maDichVu;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public String getMaBooking() {
        return maBooking;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public String toCSV() {
        return String.join(",", maHopDong, maBooking, maKhachHang, maDichVu);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "maHopDong='" + maHopDong + '\'' +
                ", maBooking='" + maBooking + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", maDichVu='" + maDichVu + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(maHopDong, contract.maHopDong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHopDong);
    }
}
