package transportation_mannerger.service;

import transportation_mannerger.entity.XeMay;

import java.util.ArrayList;

public interface IXeMayService {
    ArrayList<XeMay> findAll();
    boolean add(XeMay xeMay);
}
