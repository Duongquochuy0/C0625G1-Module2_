package furama_manage.repository;

import furama_manage.entity.NhanVien;
import furama_manage.util.ReadAndWrite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository implements INhanVienRepository {
    private static final String FILE_PATH = "furama_manage/data/nhanVien.csv";

    @Override
    public List<NhanVien> getAllEmployees() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        List<String> nhanVien = ReadAndWrite.readDataFromFile(FILE_PATH);
        for (String line : nhanVien) {
            String[] Array = line.split(",");
            NhanVien nhanViens = new NhanVien(Array[0], Array[1], LocalDate.parse(Array[2]), Array[3], Array[4], Array[5], Array[6], Array[7], Array[8], Double.parseDouble(Array[9]));
            nhanVienList.add(nhanViens);
        }
        return nhanVienList;
    }
    @Override
    public boolean addEmployee(NhanVien nhanVien) {
        try {
            List<String> nhanVienCSV = new ArrayList<>();
            nhanVienCSV.add(nhanVien.getInfoToCSV());
            ReadAndWrite.writeDataToFile(nhanVienCSV, FILE_PATH, true);
            return true;
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm nhân viên: " + e.getMessage());
            return false;
        }
    }
    @Override
    public void editEmployee(NhanVien updatedNhanVien) {
        List<NhanVien> nhanVienList = getAllEmployees();
        for (int i = 0; i < nhanVienList.size(); i++) {
            if (nhanVienList.get(i).getId().equals(updatedNhanVien.getId())) {
                nhanVienList.set(i, updatedNhanVien);
                ReadAndWrite.writeDataToFile(nhanVienList, FILE_PATH, false);
                return;
            }
        }
        System.err.println("Không tìm thấy nhân viên có ID: " + updatedNhanVien.getId());
    }
}
