package transportation_mannerger.repository;
import transportation_mannerger.entity.XeTai;

import java.util.ArrayList;

public interface IXeTaiRepository {
    ArrayList<XeTai> findAll();
    boolean add(XeTai xeTai);
    boolean delete(int bienKiemSoat);
}
