package transportation_mannerger.entity;

public class Oto extends PhuongTienGiaoThong {
    private int soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(int soChoNgoi, String kieuXe) {
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public Oto(int bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "Oto{"+ "Biển kiểm Soát "+getBienKiemSoat()+" Hãng Sản Xuất "+getTenHangSanXuat()+" Năm Sản Xuất "+ getNamSanXuat()+" Chủ sỡ hữu "+getChuSoHuu() + " soChoNgoi= " + soChoNgoi + ", kieuXe='" + kieuXe + '\'' + '}';
    }
}
