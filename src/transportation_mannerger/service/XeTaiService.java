package transportation_mannerger.service;
import transportation_mannerger.entity.XeTai;
import transportation_mannerger.repository.IXeTaiRepository;
import transportation_mannerger.repository.XeTaiRepository;

import java.util.ArrayList;

public class XeTaiService implements IXeTaiService{
    private IXeTaiRepository xeTaiRepository = new XeTaiRepository();
    @Override
    public ArrayList<XeTai> findAll(){
        return xeTaiRepository.findAll();
    }
    @Override
    public boolean add(XeTai xeTai){
        return xeTaiRepository.add(xeTai);
    }

}
