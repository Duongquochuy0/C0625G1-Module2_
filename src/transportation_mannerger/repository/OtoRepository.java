package transportation_mannerger.repository;

import transportation_mannerger.entity.Oto;

import java.util.ArrayList;

public class OtoRepository implements IOtoRepository{
    private static ArrayList<Oto> otoList = new ArrayList<>();
    static {
        Oto oto1 = new Oto(12345,"Huynhdai",2025,"Dương Quốc Huy",16,"Xe Du Lịch");
        Oto oto2 = new Oto(67890,"Thaco",2025,"Dương Quốc A",32,"Xe Khách");
        otoList.add(oto1);
        otoList.add(oto2);

    }
    @Override
    public ArrayList<Oto> findAll(){
        return otoList;
    }
    @Override
    public boolean add(Oto student) {
        otoList.add(student);
        return true;
    }
}
