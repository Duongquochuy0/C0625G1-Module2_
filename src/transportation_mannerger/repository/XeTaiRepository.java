package transportation_mannerger.repository;
import transportation_mannerger.entity.Oto;
import transportation_mannerger.entity.XeTai;

import java.util.ArrayList;

public class XeTaiRepository implements IXeTaiRepository {
    private static ArrayList<XeTai> xeTaiList = new ArrayList<>();
    static {
        XeTai xeTai1 = new XeTai(12345,"Honda",2025,"Dương Quốc Huy",2);
        XeTai xeTai2 = new XeTai(67890,"Yamaha",2025,"Dương Quốc A",3);
        xeTaiList.add(xeTai1);
        xeTaiList.add(xeTai2);
    }
    @Override
    public ArrayList<XeTai> findAll(){
        return xeTaiList;
    }
    @Override
    public boolean add(XeTai xeTai) {
        xeTaiList.add(xeTai);
        return true;
    }
    @Override
    public boolean delete(int bienKiemSoat) {
        for (XeTai xeTai : xeTaiList) {
            if (xeTai.getBienKiemSoat() == bienKiemSoat) {
                xeTaiList.remove(xeTai);
                return true;
            }
        }
        return false;
    }
    @Override
    public XeTai findByBienKiemSoat(int bienKiemSoat) {
        for (XeTai xeTai : xeTaiList) {
            if (xeTai.getBienKiemSoat() == bienKiemSoat) {
                return xeTai;
            }
        }
        return null;
    }
    @Override
    public boolean update(int bienKiemSoat, XeTai newXeTai) {
        for (int i = 0; i < xeTaiList.size(); i++) {
            if (xeTaiList.get(i).getBienKiemSoat() == bienKiemSoat) {
                xeTaiList.set(i, newXeTai);
                return true;
            }
        }
        return false;
    }
}
