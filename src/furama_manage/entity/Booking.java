package furama_manage.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private String maBooking;
    private String maKhachHang;
    private String maDichVu;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Booking(String maBooking, String maKhachHang, String maDichVu,
                   LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        this.maBooking = maBooking;
        this.maKhachHang = maKhachHang;
        this.maDichVu = maDichVu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
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
    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }
    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setMaBooking(String maBooking) {
        this.maBooking = maBooking;
    }
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }
    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public String toCSV() {
        return maBooking + "," + maKhachHang + "," + maDichVu + ","
                + ngayBatDau.format(FORMATTER) + "," + ngayKetThuc.format(FORMATTER);
    }

    @Override
    public String toString() {
        return String.format(
                "| %-7s | Khách hàng: %-8s | Dịch vụ: %-10s | Ngày bắt đầu: %s | Ngày kết thúc: %s |",
                maBooking,
                maKhachHang,
                maDichVu,
                ngayBatDau.format(FORMATTER),
                ngayKetThuc.format(FORMATTER)
        );
    }

    @Override
    public int compareTo(Booking o) {
        int result = this.ngayBatDau.compareTo(o.ngayBatDau);
        if (result == 0) {
            result = this.ngayKetThuc.compareTo(o.ngayKetThuc);
        }
        if (result == 0) {
            result = this.maBooking.compareTo(o.maBooking);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(maBooking, booking.maBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBooking);
    }
}
