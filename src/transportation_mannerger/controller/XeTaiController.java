package transportation_mannerger.controller;
import transportation_mannerger.entity.XeTai;

import transportation_mannerger.service.IXeTaiService;

import transportation_mannerger.service.XeTaiService;

import transportation_mannerger.view.XeTaiView;

import java.util.ArrayList;
import java.util.Scanner;

public class XeTaiController {
    private IXeTaiService xeTaiService = new XeTaiService();
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        final int DISPLAY = 1;
        final int ADD = 2;
        final int DELETE = 3;
        boolean flag =true;
        while (flag){
            System.out.println("Quản lý Xe Tải");
            System.out.println("-------Chức năng------" +
                    "\n 1. Danh sách các Xe Tải" +
                    "\n 2. Thêm mới Xe Tải" +
                    "\n 3. Xoá" +
                    "\n 4. Quay lại" );

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY:
                    System.out.println("----Đây là chức năng hiển thị----------");
                    ArrayList<XeTai> xeTaiList = this.xeTaiService.findAll();
                    XeTaiView.disPlay(xeTaiList);
                    break;
                case ADD:
                    System.out.println("----Đây là chức năng thêm mới----------");
                    XeTai xeTai = XeTaiView.inputDataForXeTai();
                    this.xeTaiService.add(xeTai);
                    System.out.println("- Thêm mới thành công");
                    break;
                case DELETE:
                    System.out.println("----Đây là chức năng xoá----------");
                    System.out.print("Nhập biển kiểm soát oto cần xoá: ");
                    int bienKiemSoat = Integer.parseInt(scanner.nextLine());
                    boolean isDeleted = this.xeTaiService.delete(bienKiemSoat);
                    if (isDeleted) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy xe tải có biển kiểm soát này!");
                    }
                    break;
                default:
                    flag = false;
            }
        }
    }
}
