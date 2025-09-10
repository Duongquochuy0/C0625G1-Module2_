package quan_ly_bo_de_thi.Controller;

import quan_ly_bo_de_thi.entity.CauHoi;
import quan_ly_bo_de_thi.entity.DapAn;
import quan_ly_bo_de_thi.service.CauHoiService;
import quan_ly_bo_de_thi.service.ICauHoiService;
import quan_ly_bo_de_thi.view.CauHoiView;
import quan_ly_bo_de_thi.view.DapAnView;

import java.util.Scanner;

public class DeThiController {
    private ICauHoiService cauHoiService = new CauHoiService();

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        final int ADD = 1;
        final int DISPLAY = 2;
        final int EXIT = 3;
        boolean flag = true;

        while (flag) {
            System.out.println("\n===== Quản lý đề thi =====");
            System.out.println("1. Thêm mới câu hỏi và đáp án");
            System.out.println("2. Hiển thị danh sách câu hỏi có đáp án");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case ADD:
                    themMoiCauHoi(scanner);
                    break;
                case DISPLAY:
                    hienThiCauHoi();
                    break;
                case EXIT:
                    flag = false;
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    private void themMoiCauHoi(Scanner scanner) {
        CauHoi cauHoi = CauHoiView.inputDataCauHoi();
        for (int i = 1; i <= 4; i++) {
            System.out.println("=== Nhập đáp án " + i + " ===");
            DapAn dapAn = DapAnView.inputDataDapAn(cauHoi.getMaCauHoi());
            cauHoi.themDapAn(dapAn);
        }

        boolean flag = cauHoiService.add(cauHoi);
        if (flag) {
            System.out.println(" Thêm câu hỏi thành công!");
        } else {
            System.out.println(" Thêm câu hỏi thất bại!");
        }
    }

    private void hienThiCauHoi() {
        System.out.println("\n===== Danh sách câu hỏi =====");
        for (CauHoi cauHoi : cauHoiService.findAll()) {
            CauHoiView.display(cauHoi);
        }
    }
}
