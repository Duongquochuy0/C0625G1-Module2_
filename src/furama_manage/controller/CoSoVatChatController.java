package furama_manage.controller;

import furama_manage.entity.CoSoVatChat;
import furama_manage.service.CoSoVatChatService;
import furama_manage.service.ICoSoVatChatService;

import java.util.Map;
import java.util.Scanner;

public class CoSoVatChatController {
    private final Scanner scanner = new Scanner(System.in);
    private final ICoSoVatChatService coSoVatChatService = new CoSoVatChatService();

    public void menu() {
        while (true) {
            System.out.println("---- Quản Lý Cơ Sở Vật Chất ----");
            System.out.println("1. Hiển Thị Danh Sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Danh sách hiển thị cơ sở bảo trì");
            System.out.println("4. Quay lại menu chính");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Danh sách cơ sở vật chất:");
                        Map<CoSoVatChat, Integer> allFacilities = coSoVatChatService.displayAllFacility();
                        for (Map.Entry<CoSoVatChat, Integer> entry : allFacilities.entrySet()) {
                            System.out.println(entry.getKey() + " - Số lần sử dụng: " + entry.getValue());
                        }
                        break;
                    case 2:
                        coSoVatChatService.addFacility();
                        break;
                    case 3:
                        System.out.println("Danh sách cơ sở cần bảo trì:");
                        Map<CoSoVatChat, Integer> maintenanceFacilities = coSoVatChatService.displayFacilityMaintenance();
                        if (maintenanceFacilities.isEmpty()) {
                            System.out.println("Không có cơ sở nào cần bảo trì.");
                        } else {
                            for (Map.Entry<CoSoVatChat, Integer> entry : maintenanceFacilities.entrySet()) {
                                System.out.println(entry.getKey() + " - Số lần sử dụng: " + entry.getValue());
                            }
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.err.println("Lựa chọn không hợp lệ");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Dữ liệu đầu vào không hợp lệ");
            }
        }
    }
}
