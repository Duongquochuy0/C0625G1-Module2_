package transportation_mannerger.repository;

import transportation_mannerger.entity.Oto;

import java.util.ArrayList;
import java.util.List;

public interface IOtoRepository {
    List<Oto> findAll();
    boolean add(Oto oto);
    boolean delete(int bienKiemSoat);
    boolean update(int bienKiemSoat, Oto newOto);
    Oto findByBienKiemSoat(int bienKiemSoat);

}
