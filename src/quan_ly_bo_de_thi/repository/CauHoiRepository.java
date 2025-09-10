package quan_ly_bo_de_thi.repository;

import quan_ly_bo_de_thi.entity.CauHoi;
import quan_ly_bo_de_thi.util.ReadAndWriteFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CauHoiRepository implements ICauHoiRepository {
    private final String CAU_HOI_FILE = "quan_ly_bo_de_thi/data/cauHoi.csv";

    @Override
    public List<CauHoi> findAll() {
        List<CauHoi> cauHoiList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(CAU_HOI_FILE);
            for (String line : stringList) {
                String[] array = line.split(",", 2);
                if (array.length == 2) {
                    CauHoi cauHoi = new CauHoi(array[0], array[1]);
                    cauHoiList.add(cauHoi);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return cauHoiList;
    }

    @Override
    public boolean add(CauHoi cauHoi) {
        List<String> stringList = new ArrayList<>();
        stringList.add(cauHoi.getInfoToCSV());
        try {
            ReadAndWriteFile.writeFileCSV(CAU_HOI_FILE, stringList, true);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            return false;
        }
        return true;
    }
}
