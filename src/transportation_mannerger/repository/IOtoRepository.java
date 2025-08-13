package transportation_mannerger.repository;

import transportation_mannerger.entity.Oto;

import java.util.ArrayList;

public interface IOtoRepository {
    ArrayList<Oto> findAll();
    boolean add(Oto oto);
}
