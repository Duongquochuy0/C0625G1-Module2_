package transportation_mannerger.controller;

import transportation_mannerger.entity.Oto;
import transportation_mannerger.service.IOtoService;
import transportation_mannerger.service.OtoService;
import transportation_mannerger.view.OtoView;

import java.util.ArrayList;
import java.util.Scanner;

public class OtoController {
    private IOtoService otoService = new OtoService();

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        final int DISPLAY = 1;
        final int ADD = 2;
        final int DELETE = 3;
        final int FIND =4;
        final int UPDATE =5;
        boolean flag = true;

        while (flag) {
            System.out.println("Quản lý Oto");
            System.out.println("-------Chức năng------" +
                    "\n 1. Danh sách các oto" +
                    "\n 2. Thêm mới oto" +
                    "\n 3. Xoá" +
                    "\n 4. Tìm kiếm"+
                    "\n 5. Sửa"+
                    "\n 6. Quay lại"
            );

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY:
                    System.out.println("----Đây là chức năng hiển thị----------");
                    ArrayList<Oto> otoList = this.otoService.findAll();
                    OtoView.disPlay(otoList);
                    break;

                case ADD:
                    System.out.println("----Đây là chức năng thêm mới----------");
                    Oto oto = OtoView.inputDataForOto();
                    this.otoService.add(oto);
                    System.out.println("- Thêm mới thành công");
                    break;

                case DELETE:
                    System.out.println("----Đây là chức năng xoá----------");
                    System.out.print("Nhập biển kiểm soát oto cần xoá: ");
                    int bienKiemSoat = Integer.parseInt(scanner.nextLine());
                    boolean isDeleted = this.otoService.delete(bienKiemSoat);
                    if (isDeleted) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy oto có biển kiểm soát này!");
                    }
                    break;
                case FIND:
                    System.out.print("Nhập biển kiểm soát cần tìm: ");
                    int bienKiemSoatCanTim = Integer.parseInt(scanner.nextLine());
                    Oto foundOto = otoService.findByBienKiemSoat(bienKiemSoatCanTim);
                    if (foundOto != null) {
                        OtoView.display(foundOto);
                    } else {
                        System.out.println("Không tìm thấy xe với biển kiểm soát này.");
                    }
                    break;

                case UPDATE:
                    System.out.print("Nhập biển kiểm soát cần cập nhật: ");
                    int bienKiemSoatUpdate = Integer.parseInt(scanner.nextLine());
                    Oto existingOto = otoService.findByBienKiemSoat(bienKiemSoatUpdate);

                    if (existingOto != null) {
                        System.out.println("Nhập thông tin mới cho xe:");
                        Oto newOto = OtoView.inputDataForOto();

                        newOto.setBienKiemSoat(bienKiemSoatUpdate);

                        boolean isUpdated = otoService.update(bienKiemSoatUpdate, newOto);
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
