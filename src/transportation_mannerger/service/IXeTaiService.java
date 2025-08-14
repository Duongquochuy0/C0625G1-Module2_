package transportation_mannerger.service;

import transportation_mannerger.entity.XeTai;

import java.util.ArrayList;

public interface IXeTaiService {
    ArrayList<XeTai> findAll();
    boolean add(XeTai xeTai);
    boolean delete(int bienKiemSoat);
}
