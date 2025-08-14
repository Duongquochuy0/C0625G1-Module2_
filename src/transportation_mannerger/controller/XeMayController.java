package transportation_mannerger.controller;
import transportation_mannerger.entity.XeMay;
import transportation_mannerger.service.IXeMayService;
import transportation_mannerger.service.XeMayService;
import transportation_mannerger.view.XeMayView;

import java.util.ArrayList;
import java.util.Scanner;

public class XeMayController {
    private IXeMayService xeMayService = new XeMayService();
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        final int DISPLAY = 1;
        final int ADD = 2;
        final int DELETE = 3;
        boolean flag =true;
        while (flag){
            System.out.println("Quản lý Xe Máy");
            System.out.println("-------Chức năng------" +
                    "\n 1. Danh sách các xe máy" +
                    "\n 2. Thêm mới xe máy" +
                    "\n 3. Xoá" +
                    "\n 4. Quay lại" );

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY:
                    System.out.println("----Đây là chức năng hiển thị----------");
                    ArrayList<XeMay> xeMayList = this.xeMayService.findAll();
                    XeMayView.disPlay(xeMayList);
                    break;
                case ADD:
                    System.out.println("----Đây là chức năng thêm mới----------");
                    XeMay xeMay = XeMayView.inputDataForXeMay();
                    this.xeMayService.add(xeMay);
                    System.out.println("- Thêm mới thành công");
                    break;
                case DELETE:
                    System.out.println("----Đây là chức năng xoá----------");
                    System.out.print("Nhập biển kiểm soát xe máy cần xoá: ");
                    int bienKiemSoat = Integer.parseInt(scanner.nextLine());
                    boolean isDeleted = this.xeMayService.delete(bienKiemSoat);
                    if (isDeleted) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy xe máy có biển kiểm soát này!");
                    }
                    break;
                default:
                    flag = false;
            }
        }
    }
}
