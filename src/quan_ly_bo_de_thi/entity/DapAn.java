package quan_ly_bo_de_thi.entity;

public class DapAn {
    private String maCauHoi;
    private String maDapAn;
    private String noiDungDapAn;
    private boolean dapAnDung;

    public DapAn() {
    }

    public DapAn(String maCauHoi, String maDapAn, String noiDungDapAn, boolean dapAnDung) {
        this.maCauHoi = maCauHoi;
        this.maDapAn = maDapAn;
        this.noiDungDapAn = noiDungDapAn;
        this.dapAnDung = dapAnDung;
    }

    public String getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getMaDapAn() {
        return maDapAn;
    }

    public void setMaDapAn(String maDapAn) {
        this.maDapAn = maDapAn;
    }

    public String getNoiDungDapAn() {
        return noiDungDapAn;
    }

    public void setNoiDungDapAn(String noiDungDapAn) {
        this.noiDungDapAn = noiDungDapAn;
    }

    public boolean isDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(boolean dapAnDung) {
        this.dapAnDung = dapAnDung;
    }
    public String getInfoToCSV() {
        return maDapAn + "," + maCauHoi + "," + noiDungDapAn + "," + dapAnDung;
    }
    public void display() {
        System.out.println("   - " + maDapAn + ": " + noiDungDapAn + (dapAnDung ? " [Đúng]" : ""));
    }
}
