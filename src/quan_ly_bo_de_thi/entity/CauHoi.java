package quan_ly_bo_de_thi.entity;

import java.util.ArrayList;
import java.util.List;

public class CauHoi {
    private String maCauHoi;
    private String noiDungCauHoi;
    private List<DapAn> dapAns = new ArrayList<>();

    public CauHoi() {
    }

    public CauHoi(String maCauHoi, String noiDungCauHoi) {
        this.maCauHoi = maCauHoi;
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public String getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getNoiDungCauHoi() {
        return noiDungCauHoi;
    }

    public void setNoiDungCauHoi(String noiDungCauHoi) {
        this.noiDungCauHoi = noiDungCauHoi;
    }

    public void themDapAn(DapAn dapAn) {
        dapAns.add(dapAn);
    }
    public List<DapAn> getDapAns() {
        return dapAns;
    }
    public String getInfoToCSV() {
        return maCauHoi + "," + noiDungCauHoi;
    }
    public void display() {
        System.out.println("[" + maCauHoi + "] " + noiDungCauHoi);
        for (DapAn dapAn : dapAns) {
            dapAn.display();
        }
    }
}
