package transportation_mannerger.service;

import transportation_mannerger.entity.XeTai;

import java.util.ArrayList;
import java.util.List;

public interface IXeTaiService {
    List<XeTai> findAll();
    boolean add(XeTai xeTai);
    boolean delete(int bienKiemSoat);
    boolean update(int bienKiemSoat, XeTai newXeTai);
    XeTai findByBienKiemSoat(int bienKiemSoat);
}
