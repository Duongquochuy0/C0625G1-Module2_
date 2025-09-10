package quan_ly_bo_de_thi.repository;

import quan_ly_bo_de_thi.entity.DapAn;
import quan_ly_bo_de_thi.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DapAnRepository implements IDapAnRepository {
    private final String DAP_AN_FILE = "quan_ly_bo_de_thi/data/dapAn.csv";

    @Override
    public List<DapAn> findAll() {
        List<DapAn> dapAnList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(DAP_AN_FILE);
            for (String line : stringList) {
                String[] array = line.split(",", 4);
                if (array.length == 4) {
                    String maDapAn = array[0];
                    String maCauHoi = array[1];
                    String noiDung = array[2];
                    boolean dapAnDung = Boolean.parseBoolean(array[3]);
                    DapAn dapAn = new DapAn(maCauHoi, maDapAn, noiDung, dapAnDung);
                    dapAnList.add(dapAn);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file đáp án: " + e.getMessage());
        }
        return dapAnList;
    }

    @Override
    public boolean add(DapAn dapAn) {
        List<String> stringList = new ArrayList<>();
        stringList.add(dapAn.getInfoToCSV());
        try {
            ReadAndWriteFile.writeFileCSV(DAP_AN_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file đáp án: " + e.getMessage());
            return false;
        }
        return true;
    }
}
