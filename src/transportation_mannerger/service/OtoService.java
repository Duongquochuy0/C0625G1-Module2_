package transportation_mannerger.service;

import transportation_mannerger.entity.Oto;
import transportation_mannerger.repository.IOtoRepository;
import transportation_mannerger.repository.OtoRepository;

import java.util.ArrayList;
import java.util.List;

public class OtoService implements IOtoService {
    private IOtoRepository otoRepository = new OtoRepository();
    @Override
    public List<Oto> findAll(){
        return otoRepository.findAll();
    }
    @Override
    public boolean add(Oto oto){
        return otoRepository.add(oto);
    }
    public boolean delete(int bienKiemSoat) {
        return otoRepository.delete(bienKiemSoat);
    }

    @Override
    public boolean update(int bienKiemSoat, Oto newOto) {
        return otoRepository.update(bienKiemSoat, newOto);
    }


    @Override
    public Oto findByBienKiemSoat(int bienKiemSoat) {
        return otoRepository.findByBienKiemSoat(bienKiemSoat);
    }
}
