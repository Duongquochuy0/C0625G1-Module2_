package furama_manage.repository;

import furama_manage.entity.CoSoVatChat;
import furama_manage.entity.House;
import furama_manage.entity.Room;
import furama_manage.entity.Villa;
import furama_manage.util.ReadAndWrite;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CoSoVatChatRepository implements ICoSoVatChatRepository{
    private static final String FILE_PATH="furama_manage/data/coSoVatChat.csv";
    private static Map<CoSoVatChat, Integer> coSoVatChatIntegerMap =new LinkedHashMap<>();
    static {
        List<String> facilityData = ReadAndWrite.readDataFromFile(FILE_PATH);
        for (String line : facilityData) {
            String[] data = line.split(",");
            if (data[0].startsWith("SVVL")) {
                coSoVatChatIntegerMap.put(new Villa(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5], data[6], Double.parseDouble(data[7]), Integer.parseInt(data[8])), Integer.parseInt(data[9]));
            } else if (data[0].startsWith("SVHO")) {
                coSoVatChatIntegerMap.put(new House(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5], data[6], Integer.parseInt(data[7])), Integer.parseInt(data[8]));
            } else if (data[0].startsWith("SVRO")) {
                coSoVatChatIntegerMap.put(new Room(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]), data[5], data[6]), Integer.parseInt(data[7]));
            }
        }
    }

    @Override
    public Map<CoSoVatChat, Integer> getAllFacilities() {
        return coSoVatChatIntegerMap;
    }

    @Override
    public void addFacility(CoSoVatChat facility) {
        coSoVatChatIntegerMap.put(facility, 0);
        ReadAndWrite.writeFacilityToFile(FILE_PATH, coSoVatChatIntegerMap);
    }
    @Override
    public Map<CoSoVatChat, Integer> getFacilitiesForMaintenance() {
        Map<CoSoVatChat, Integer> maintenanceFacilities = new LinkedHashMap<>();
        for (Map.Entry<CoSoVatChat, Integer> entry : coSoVatChatIntegerMap.entrySet()) {
            if (entry.getValue() >= 5) {
                maintenanceFacilities.put(entry.getKey(), entry.getValue());
            }
        }
        return maintenanceFacilities;
    }
//    @Override
//    public void updateFacilityUsage(String facilityId) {
//        for (Map.Entry<CoSoVatChat, Integer> entry : coSoVatChatIntegerMap.entrySet()) {
//            if (entry.getKey().getMaDichVu().equals(facilityId)) {
//                entry.setValue(entry.getValue() + 1);
//                ReadAndWrite.writeFacilityToFile(FILE_PATH, coSoVatChatIntegerMap);
//                return;
//            }
//        }
//    }
}
