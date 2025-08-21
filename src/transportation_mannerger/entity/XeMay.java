package transportation_mannerger.entity;

public class XeMay extends PhuongTienGiaoThong {
    private int congSuat;

    public XeMay() {
    }

    @Override
    public String getInfoToCSV() {
        return this.getBienKiemSoat()+","+this.getTenHangSanXuat()+","+this.getNamSanXuat()+","+this.getChuSoHuu()+","+this.getCongSuat();
    }

    public XeMay(int congSuat) {
        this.congSuat = congSuat;
    }

    public XeMay(int bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public String toString() {
        return "Xe máy{"+ "Biển kiểm Soát: "+getBienKiemSoat()+" Hãng Sản Xuất: "+getTenHangSanXuat()+" Năm Sản Xuất: "+ getNamSanXuat()+" Chủ sỡ hữu: "+getChuSoHuu() + " Công suất= " + getCongSuat() +  '\'' + '}';
    }
}
