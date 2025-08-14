package transportation_mannerger.repository;

import transportation_mannerger.entity.Oto;

import java.util.ArrayList;

public class OtoRepository implements IOtoRepository {
    private static ArrayList<Oto> otoList = new ArrayList<>();

    static {
        Oto oto1 = new Oto(12345, "Huynhdai", 2025, "Dương Quốc Huy", 16, "Xe Du Lịch");
        Oto oto2 = new Oto(67890, "Thaco", 2025, "Dương Quốc A", 32, "Xe Khách");
        otoList.add(oto1);
        otoList.add(oto2);
    }

    @Override
    public ArrayList<Oto> findAll() {
        return otoList;
    }

    @Override
    public boolean add(Oto oto) {
        otoList.add(oto);
        return true;
    }

    @Override
    public boolean delete(int bienKiemSoat) {
        for (Oto oto : otoList) {
            if (oto.getBienKiemSoat() == bienKiemSoat) {
                otoList.remove(oto);
                return true;
            }
        }
        return false;
    }
    @Override
    public Oto findByBienKiemSoat(int bienKiemSoat) {
        for (Oto oto : otoList) {
            if (oto.getBienKiemSoat() == bienKiemSoat) {
                return oto;
            }
        }
        return null;
    }
    @Override
    public boolean update(int bienKiemSoat, Oto newOto) {
        for (int i = 0; i < otoList.size(); i++) {
            if (otoList.get(i).getBienKiemSoat() == bienKiemSoat) {
                otoList.set(i, newOto);
                return true;
            }
        }
        return false;
    }

}
