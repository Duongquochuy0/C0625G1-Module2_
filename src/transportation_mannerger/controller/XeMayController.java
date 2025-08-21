package transportation_mannerger.controller;
import transportation_mannerger.entity.Oto;
import transportation_mannerger.entity.XeMay;
import transportation_mannerger.service.IXeMayService;
import transportation_mannerger.service.XeMayService;
import transportation_mannerger.view.OtoView;
import transportation_mannerger.view.XeMayView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeMayController {
    private IXeMayService xeMayService = new XeMayService();
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        final int DISPLAY = 1;
        final int ADD = 2;
        final int DELETE = 3;
        final int FIND =4;
        final int UPDATE =5;
        boolean flag = true;

        while (flag) {
            System.out.println("Quản lý Xe Máy");
            System.out.println("-------Chức năng------" +
                    "\n 1. Danh sách các oto.csv" +
                    "\n 2. Thêm mới oto.csv" +
                    "\n 3. Xoá" +
                    "\n 4. Tìm kiếm"+
                    "\n 5. Sửa"+
                    "\n 6. Quay lại"
            );

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY:
                    System.out.println("----Đây là chức năng hiển thị----------");
                    List<XeMay> xeMayList = this.xeMayService.findAll();
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
                case FIND:
                    System.out.print("Nhập biển kiểm soát cần tìm: ");
                    int bienKiemSoatCanTim = Integer.parseInt(scanner.nextLine());
                    XeMay foundXeMay = xeMayService.findByBienKiemSoat(bienKiemSoatCanTim);
                    if (foundXeMay != null) {
                        XeMayView.display(foundXeMay);
                    } else {
                        System.out.println("Không tìm thấy xe với biển kiểm soát này.");
                    }
                    break;
                case UPDATE:
                    System.out.print("Nhập biển kiểm soát cần cập nhật: ");
                    int bienKiemSoatUpdate = Integer.parseInt(scanner.nextLine());
                    XeMay existingXeMay = xeMayService.findByBienKiemSoat(bienKiemSoatUpdate);

                    if (existingXeMay != null) {
                        System.out.println("Nhập thông tin mới cho xe:");
                        XeMay newXeMay = XeMayView.inputDataForXeMay();
                        newXeMay.setBienKiemSoat(bienKiemSoatUpdate);

                        boolean isUpdated = xeMayService.update(bienKiemSoatUpdate, newXeMay);
                        if (isUpdated) {
                            System.out.println("Cập nhật thành công!");
                        } else {
                            System.out.println("Cập nhật thất bại!");
                        }
                    } else {
                        System.out.println("Không tìm thấy xe với biển kiểm soát này!");
                    }
                    break;
                default:
                    flag = false;
            }
        }
    }
}
