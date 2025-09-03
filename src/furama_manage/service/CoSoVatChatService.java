package furama_manage.service;

import furama_manage.entity.CoSoVatChat;
import furama_manage.entity.House;
import furama_manage.entity.Room;
import furama_manage.entity.Villa;
import furama_manage.repository.CoSoVatChatRepository;
import furama_manage.repository.ICoSoVatChatRepository;
import furama_manage.view.CoSoVatChatView;

import java.util.Map;
import java.util.Scanner;

public class CoSoVatChatService implements ICoSoVatChatService {
    private ICoSoVatChatRepository coSoVatChatRepository = new CoSoVatChatRepository();
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public Map<CoSoVatChat, Integer> displayAllFacility() {
        return coSoVatChatRepository.getAllFacilities();
    }

    @Override
    public void addFacility() {
        while (true) {
            try {
                System.out.println("--- Menu thêm mới ---");
                System.out.println("1. Thêm mới Villa");
                System.out.println("2. Thêm mới House");
                System.out.println("3. Thêm mới Room");
                System.out.println("4. Quay lại menu chính");
                System.out.print("Nhập lựa chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        Villa newVilla = CoSoVatChatView.nhapVilla();
                        coSoVatChatRepository.addFacility(newVilla);
                        return;
                    case 2:
                        House newHouse = CoSoVatChatView.nhapHouse();
                        coSoVatChatRepository.addFacility(newHouse);
                        return;
                    case 3:
                        Room newRoom = CoSoVatChatView.nhapRoom();
                        coSoVatChatRepository.addFacility(newRoom);
                        return;
                    case 4:
                        return;
                    default:
                        System.err.println("Lựa chọn không hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Định dạng không hợp lệ");
            }
        }
    }

    @Override
    public Map<CoSoVatChat, Integer> displayFacilityMaintenance() {
        return coSoVatChatRepository.getFacilitiesForMaintenance();
    }
}
