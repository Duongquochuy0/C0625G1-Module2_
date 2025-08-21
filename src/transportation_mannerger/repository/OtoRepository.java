package transportation_mannerger.repository;

import transportation_mannerger.entity.Oto;
import transportation_mannerger.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OtoRepository implements IOtoRepository {
    private final String OTO_FILE="src/transportation_mannerger/data/oto.csv";
    @Override
    public List<Oto> findAll() {
        List<Oto> otoList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(OTO_FILE);
            String[] array = null;
            for (String line: stringList) {
                array = line.split(",");
                Oto oto = new Oto(Integer.parseInt(array[0]),array[1],Integer.parseInt(array[2]),array[3],Integer.parseInt(array[4]),array[5]);
                otoList.add(oto);
            }
        } catch (IOException e) {
            System.out.println("lỗi đọc file");
        }
        return otoList;
    }

    @Override
    public boolean add(Oto oto) {
        List<String> stringList = new ArrayList<>();
        stringList.add(oto.getInfoToCSV());
        try{
            ReadAndWriteFile.writeFileCSV(OTO_FILE,stringList,true);
        }catch (IOException e){
            System.out.println("Lỗi ghi file");
            return false;
        }
        return true;
    }


    @Override
    public boolean delete(int bienKiemSoat) {
        try {
            List<Oto> otoList = findAll();
            boolean removed = false;
            for (int i = 0; i < otoList.size(); i++) {
                if (otoList.get(i).getBienKiemSoat() == bienKiemSoat) {
                    otoList.remove(i);
                    removed = true;
                    break;
                }
            }if (removed) {
                List<String> stringList = new ArrayList<>();
                for (Oto o : otoList) {
                    stringList.add(o.getInfoToCSV());
                }
                ReadAndWriteFile.writeFileCSV(OTO_FILE, stringList, false);
            }
            return removed;
        } catch (IOException e) {
            System.out.println("Lỗi xóa dữ liệu");
            return false;
        }
    }
    @Override
    public boolean update(int bienKiemSoat, Oto newOto) {
        try {
            List<Oto> otoList = findAll();
            boolean updated = false;
            for (int i = 0; i < otoList.size(); i++) {
                if (otoList.get(i).getBienKiemSoat() == bienKiemSoat) {
                    otoList.set(i, newOto);
                    updated = true;
                    break;
                }
            }if (updated) {
                List<String> stringList = new ArrayList<>();
                for (Oto o : otoList) {
                    stringList.add(o.getInfoToCSV());
                }
                ReadAndWriteFile.writeFileCSV(OTO_FILE, stringList, false);
            }
            return updated;
        } catch (IOException e) {
            System.out.println("Lỗi cập nhật dữ liệu");
            return false;
        }
    }


    @Override
    public Oto findByBienKiemSoat(int bienKiemSoat) {
        List<Oto> otoList = findAll();
        for (Oto oto : otoList) {
            if (oto.getBienKiemSoat() == bienKiemSoat) {
                return oto;
            }
        }
        return null;
    }


}
