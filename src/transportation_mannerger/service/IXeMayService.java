package transportation_mannerger.service;

import transportation_mannerger.entity.Oto;
import transportation_mannerger.entity.XeMay;

import java.util.ArrayList;

public interface IXeMayService {
    ArrayList<XeMay> findAll();
    boolean add(XeMay xeMay);
    boolean delete(int bienKiemSoat);
    boolean update(int bienKiemSoat, XeMay newXeMay);
    XeMay findByBienKiemSoat(int bienKiemSoat);
}
