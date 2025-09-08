package furama_manage.repository;

import furama_manage.entity.KhachHang;
import furama_manage.util.ReadAndWrite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository implements IKhachHangRepository {
    private static final String FILE_PATH = "furama_manage/data/khachHang.csv";

    @Override
    public List<KhachHang> getAllCustomer() {
        List<KhachHang> khachHangList = new ArrayList<>();
        List<String> data = ReadAndWrite.readDataFromFile(FILE_PATH);
        for (String line : data) {
            String[] array = line.split(",");
            if (array.length == 9) {
                try {
                    KhachHang khachHang = new KhachHang(
                            array[0], array[1], LocalDate.parse(array[2]),
                            array[3], array[4], array[5], array[6], array[7], array[8]
                    );
                    khachHangList.add(khachHang);
                } catch (Exception e) {
                    System.err.println("❌ Lỗi khi đọc dòng dữ liệu: " + line);
                    e.printStackTrace();
                }
            } else {
                System.err.println("❌ Dòng dữ liệu không đúng định dạng: " + line);
            }
        }
        return khachHangList;
    }

    @Override
    public boolean addCustomer(KhachHang khachHang) {
        try {
            List<String> khachHangCSV = new ArrayList<>();
            khachHangCSV.add(khachHang.getInfoToCSV());
            ReadAndWrite.writeDataToFile(khachHangCSV, FILE_PATH, true);
            return true;
        } catch (Exception e) {
            System.err.println("❌ Lỗi khi thêm khách hàng: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void editCustomer(KhachHang updateKhachHang) {
        List<KhachHang> khachHangList = getAllCustomer();
        boolean found = false;
        for (int i = 0; i < khachHangList.size(); i++) {
            if (khachHangList.get(i).getId().equals(updateKhachHang.getId())) {
                khachHangList.set(i, updateKhachHang);
                found = true;
                break;
            }
        }

        if (found) {
            // Ghi lại toàn bộ danh sách khách hàng
            List<String> dataToWrite = new ArrayList<>();
            for (KhachHang kh : khachHangList) {
                dataToWrite.add(kh.getInfoToCSV());
            }
            ReadAndWrite.writeDataToFile(dataToWrite, FILE_PATH, false);
        } else {
            System.out.println("❌ Không tìm thấy khách hàng có id: " + updateKhachHang.getId());
        }
    }

    // ✅ Thêm hàm để BookingRepository gọi
    public boolean existsById(String id) {
        List<KhachHang> khachHangList = getAllCustomer();
        for (KhachHang c : khachHangList) {
            if (c.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
