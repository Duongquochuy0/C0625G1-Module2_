package transportation_mannerger.entity;

public class XeTai extends PhuongTienGiaoThong {
    private int trongTai;

    public XeTai() {
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    public XeTai(int trongTai) {
        this.trongTai = trongTai;
    }

    public XeTai(int bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, int trongTai) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "Xe Tải{"+ "Biển kiểm Soát "+getBienKiemSoat()+" Hãng Sản Xuất "+getTenHangSanXuat()+" Năm Sản Xuất "+ getNamSanXuat()+" Chủ sỡ hữu "+getChuSoHuu() + " Trọng tải= " + getTrongTai() +  '\'' + '}';
    }
}
