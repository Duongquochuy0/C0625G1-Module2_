package transportation_mannerger.repository;

import transportation_mannerger.entity.XeTai;
import transportation_mannerger.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XeTaiRepository implements IXeTaiRepository {
    private final String XETAI_FILE = "src/transportation_mannerger/data/xeTai.csv";

    @Override
    public List<XeTai> findAll() {
        List<XeTai> xeTaiList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(XETAI_FILE);
            String[] array = null;
            for (String line : stringList) {
                array = line.split(",");
                XeTai xeTai = new XeTai(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), array[3], Integer.parseInt(array[4]));
                xeTaiList.add(xeTai);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file Xe Tải");
        }
        return xeTaiList;
    }

    @Override
    public boolean add(XeTai xeTai) {
        List<String> stringList = new ArrayList<>();
        stringList.add(xeTai.getInfoToCSV());
        try {
            ReadAndWriteFile.writeFileCSV(XETAI_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file Xe Tải");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int bienKiemSoat) {
        try {
            List<XeTai> xeTaiList = findAll();
            boolean removed = false;
            for (int i = 0; i < xeTaiList.size(); i++) {
                if (xeTaiList.get(i).getBienKiemSoat() == bienKiemSoat) {
                    xeTaiList.remove(i);
                    removed = true;
                    break;
                }
            }
            if (removed) {
                List<String> stringList = new ArrayList<>();
                for (XeTai xt : xeTaiList) {
                    stringList.add(xt.getInfoToCSV());
                }
                ReadAndWriteFile.writeFileCSV(XETAI_FILE, stringList, false);
            }
            return removed;
        } catch (IOException e) {
            System.out.println("Lỗi xóa dữ liệu Xe Tải");
            return false;
        }
    }

    @Override
    public boolean update(int bienKiemSoat, XeTai newXeTai) {
        try {
            List<XeTai> xeTaiList = findAll();
            boolean updated = false;
            for (int i = 0; i < xeTaiList.size(); i++) {
                if (xeTaiList.get(i).getBienKiemSoat() == bienKiemSoat) {
                    xeTaiList.set(i, newXeTai);
                    updated = true;
                    break;
                }
            }
            if (updated) {
                List<String> stringList = new ArrayList<>();
                for (XeTai xt : xeTaiList) {
                    stringList.add(xt.getInfoToCSV());
                }
                ReadAndWriteFile.writeFileCSV(XETAI_FILE, stringList, false);
            }
            return updated;
        } catch (IOException e) {
            System.out.println("Lỗi cập nhật dữ liệu Xe Tải");
            return false;
        }
    }

    @Override
    public XeTai findByBienKiemSoat(int bienKiemSoat) {
        List<XeTai> xeTaiList = findAll();
        for (XeTai xeTai : xeTaiList) {
            if (xeTai.getBienKiemSoat() == bienKiemSoat) {
                return xeTai;
            }
        }
        return null;
    }
}
