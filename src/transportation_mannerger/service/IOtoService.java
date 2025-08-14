package transportation_mannerger.service;

import transportation_mannerger.entity.Oto;

import java.util.ArrayList;

public interface IOtoService {
    ArrayList<Oto> findAll();
    boolean add(Oto oto);
    boolean delete(int bienKiemSoat);
    boolean update(int bienKiemSoat, Oto newOto);
    Oto findByBienKiemSoat(int bienKiemSoat);
}
