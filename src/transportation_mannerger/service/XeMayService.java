package transportation_mannerger.service;

import transportation_mannerger.entity.Oto;
import transportation_mannerger.entity.XeMay;

import transportation_mannerger.entity.XeTai;
import transportation_mannerger.repository.IXeMayRepository;

import transportation_mannerger.repository.XeMayRepository;

import java.util.ArrayList;

public class XeMayService implements IXeMayService {
    private IXeMayRepository xeMayRepository = new XeMayRepository();
    @Override
    public ArrayList<XeMay> findAll(){
        return xeMayRepository.findAll();
    }
    @Override
    public boolean add(XeMay xeMay){
        return xeMayRepository.add(xeMay);
    }
    public boolean delete(int bienKiemSoat) {
        return xeMayRepository.delete(bienKiemSoat);
    }
    @Override
    public XeMay findByBienKiemSoat(int bienKiemSoat) {
        return xeMayRepository.findByBienKiemSoat(bienKiemSoat);
    }
    @Override
    public boolean update(int bienKiemSoat, XeMay newXeMay) {
        return xeMayRepository.update(bienKiemSoat, newXeMay);
    }
}
