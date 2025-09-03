package furama_manage.util;

import furama_manage.entity.CoSoVatChat;
import furama_manage.entity.House;
import furama_manage.entity.Room;
import furama_manage.entity.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadAndWrite {
    public static <T> void writeDataToFile(List<T> data, String filePath, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            for (T item : data) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<String> readDataFromFile(String filePath) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return data;
    }
    public static void writeFacilityToFile(String filePath, Map<CoSoVatChat, Integer> facilityMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (Map.Entry<CoSoVatChat, Integer> entry : facilityMap.entrySet()) {
                CoSoVatChat facility = entry.getKey();
                int usageCount = entry.getValue();
                if (facility instanceof Villa) {
                    Villa villa = (Villa) facility;
                    writer.write(villa.getMaDichVu() + "," + villa.getTenDichVu() + "," + villa.getDienTich() + "," + villa.getChiPhi() + "," + villa.getSoLuongNguoi() + "," + villa.getKieuThue() + "," + villa.getTieuChuanPhong() + "," + villa.getDienTichHoBoi() + "," + villa.getSoTang() + "," + usageCount);
                } else if (facility instanceof House) {
                    House house = (House) facility;
                    writer.write(house.getMaDichVu() + "," + house.getTenDichVu() + "," + house.getDienTich() + "," + house.getChiPhi() + "," + house.getSoLuongNguoi() + "," + house.getKieuThue() + "," + house.getTieuChuanPhong() + "," + house.getSoTang() + "," + usageCount);
                } else if (facility instanceof Room) {
                    Room room = (Room) facility;
                    writer.write(room.getMaDichVu() + "," + room.getTenDichVu() + "," + room.getDienTich() + "," + room.getChiPhi() + "," + room.getSoLuongNguoi() + "," + room.getKieuThue() + "," + room.getDichVuMienPhi() + "," + usageCount);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing facilities to file: " + e.getMessage());
        }
    }
}
