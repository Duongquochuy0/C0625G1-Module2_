package transportation_mannerger.repository;

import transportation_mannerger.entity.XeMay;
import transportation_mannerger.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XeMayRepository implements IXeMayRepository {
    private final String XEMAY_FILE = "src/transportation_mannerger/data/xeMay.csv";

    @Override
    public List<XeMay> findAll() {
        List<XeMay> xeMayList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(XEMAY_FILE);
            String[] array = null;
            for (String line : stringList) {
                array = line.split(",");
                XeMay xeMay = new XeMay(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), array[3], Integer.parseInt(array[4]));
                xeMayList.add(xeMay);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file Xe Máy");
        }
        return xeMayList;
    }

    @Override
    public boolean add(XeMay xeMay) {
        List<String> stringList = new ArrayList<>();
        stringList.add(xeMay.getInfoToCSV());
        try {
            ReadAndWriteFile.writeFileCSV(XEMAY_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file Xe Máy");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int bienKiemSoat) {
        try {
            List<XeMay> xeMayList = findAll();
            boolean removed = false;
            for (int i = 0; i < xeMayList.size(); i++) {
                if (xeMayList.get(i).getBienKiemSoat() == bienKiemSoat) {
                    xeMayList.remove(i);
                    removed = true;
                    break;
                }
            }
            if (removed) {
                List<String> stringList = new ArrayList<>();
                for (XeMay xm : xeMayList) {
                    stringList.add(xm.getInfoToCSV());
                }
                ReadAndWriteFile.writeFileCSV(XEMAY_FILE, stringList, false);
            }
            return removed;
        } catch (IOException e) {
            System.out.println("Lỗi xóa dữ liệu Xe Máy");
            return false;
        }
    }

    @Override
    public boolean update(int bienKiemSoat, XeMay newXeMay) {
        try {
            List<XeMay> xeMayList = findAll();
            boolean updated = false;
            for (int i = 0; i < xeMayList.size(); i++) {
                if (xeMayList.get(i).getBienKiemSoat() == bienKiemSoat) {
                    xeMayList.set(i, newXeMay);
                    updated = true;
                    break;
                }
            }
            if (updated) {
                List<String> stringList = new ArrayList<>();
                for (XeMay xm : xeMayList) {
                    stringList.add(xm.getInfoToCSV());
                }
                ReadAndWriteFile.writeFileCSV(XEMAY_FILE, stringList, false);
            }
            return updated;
        } catch (IOException e) {
            System.out.println("Lỗi cập nhật dữ liệu Xe Máy");
            return false;
        }
    }

    @Override
    public XeMay findByBienKiemSoat(int bienKiemSoat) {
        List<XeMay> xeMayList = findAll();
        for (XeMay xeMay : xeMayList) {
            if (xeMay.getBienKiemSoat() == bienKiemSoat) {
                return xeMay;
            }
        }
        return null;
    }
}
