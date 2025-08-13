package transportation_mannerger.repository;
import transportation_mannerger.entity.XeMay;

import java.util.ArrayList;

public interface IXeMayRepository {
    ArrayList<XeMay> findAll();
    boolean add(XeMay xeMay);

}
