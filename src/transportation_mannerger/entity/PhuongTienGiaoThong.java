package transportation_mannerger.entity;

public class PhuongTienGiaoThong {
    private int bienKiemSoat;
    private String tenHangSanXuat;
    private int namSanXuat;
    private String chuSoHuu;

    public PhuongTienGiaoThong() {
    }

    public PhuongTienGiaoThong(int bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public int getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(int bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "bienKiemSoat=" + bienKiemSoat +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}';
    }
}
