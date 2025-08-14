package transportation_mannerger.repository;
import transportation_mannerger.entity.Oto;
import transportation_mannerger.entity.XeMay;
import transportation_mannerger.entity.XeTai;

import java.util.ArrayList;

public class XeMayRepository implements IXeMayRepository {
    private static ArrayList<XeMay> xeMayList = new ArrayList<>();
    static {
        XeMay xeMay1 = new XeMay(12345,"Honda",2025,"Dương Quốc Huy",150);
        XeMay xeMay2 = new XeMay(67890,"Yamaha",2025,"Dương Quốc A",125);
        xeMayList.add(xeMay1);
        xeMayList.add(xeMay2);
    }
    @Override
    public ArrayList<XeMay> findAll(){
        return xeMayList;
    }
    @Override
    public boolean add(XeMay xeMay) {
        xeMayList.add(xeMay);
        return true;
    }
    @Override
    public boolean delete(int bienKiemSoat) {
        for (XeMay xeMay : xeMayList) {
            if (xeMay.getBienKiemSoat() == bienKiemSoat) {
                xeMayList.remove(xeMay);
                return true;
            }
        }
        return false;
    }
    @Override
    public XeMay findByBienKiemSoat(int bienKiemSoat) {
        for (XeMay xeMay : xeMayList) {
            if (xeMay.getBienKiemSoat() == bienKiemSoat) {
                return xeMay;
            }
        }
        return null;
    }
    @Override
    public boolean update(int bienKiemSoat, XeMay newXeMay ){
        for (int i = 0; i < xeMayList.size(); i++) {
            if (xeMayList.get(i).getBienKiemSoat() == bienKiemSoat) {
                xeMayList.set(i, newXeMay);
                return true;
            }
        }
        return false;
    }
}
