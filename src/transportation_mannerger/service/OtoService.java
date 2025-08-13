package transportation_mannerger.service;

import transportation_mannerger.entity.Oto;
import transportation_mannerger.repository.IOtoRepository;
import transportation_mannerger.repository.OtoRepository;

import java.util.ArrayList;

public class OtoService implements IOtoService {
    private IOtoRepository otoRepository = new OtoRepository();
    @Override
    public ArrayList<Oto> findAll(){
        return otoRepository.findAll();
    }
    @Override
    public boolean add(Oto oto){
        return otoRepository.add(oto);
    }
}
