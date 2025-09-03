package furama_manage.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private String maBooking;
    private String maKhachHang;
    private String maDichVu;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
    public String getMaKhachHang() { return maKhachHang; }
    public String getMaDichVu() { return maDichVu; }
    public LocalDate getNgayBatDau() { return ngayBatDau; }
    public LocalDate getNgayKetThuc() { return ngayKetThuc; }
    public void setMaBooking(String maBooking) { this.maBooking = maBooking; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }
    public void setMaDichVu(String maDichVu) { this.maDichVu = maDichVu; }
    public void setNgayBatDau(LocalDate ngayBatDau) { this.ngayBatDau = ngayBatDau; }
    public void setNgayKetThuc(LocalDate ngayKetThuc) { this.ngayKetThuc = ngayKetThuc; }
    public String toCSV() {
        return maBooking + "," + maKhachHang + "," + maDichVu + ","
                + ngayBatDau.format(formatter) + "," + ngayKetThuc.format(formatter);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "maBooking='" + maBooking + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", maDichVu='" + maDichVu + '\'' +
                ", ngayBatDau=" + ngayBatDau.format(formatter) +
                ", ngayKetThuc=" + ngayKetThuc.format(formatter) +
                '}';
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
    @Override
    public int compareTo(Booking o) {
        int result = this.ngayBatDau.compareTo(o.ngayBatDau);
        if (result == 0) {
            result = this.ngayKetThuc.compareTo(o.ngayKetThuc);
        }
        return result;
    }
    public static class BookingComparator implements Comparator<Booking> {
        @Override
        public int compare(Booking b1, Booking b2) {
            int result = b1.getNgayBatDau().compareTo(b2.getNgayBatDau());
            if (result == 0) {
                result = b1.getNgayKetThuc().compareTo(b2.getNgayKetThuc());
            }
            return result;
        }
    }
}
