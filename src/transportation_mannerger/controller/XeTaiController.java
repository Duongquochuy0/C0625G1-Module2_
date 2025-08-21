package transportation_mannerger.controller;
import transportation_mannerger.entity.Oto;
import transportation_mannerger.entity.XeTai;
import transportation_mannerger.service.IXeTaiService;
import transportation_mannerger.service.XeTaiService;
import transportation_mannerger.view.OtoView;
import transportation_mannerger.view.XeMayView;
import transportation_mannerger.view.XeTaiView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeTaiController {
    private IXeTaiService xeTaiService = new XeTaiService();
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        final int DISPLAY = 1;
        final int ADD = 2;
        final int DELETE = 3;
        final int FIND =4;
        final int UPDATE =5;
        boolean flag = true;

        while (flag) {
            System.out.println("Quản lý Xe Tải");
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
                    List<XeTai> xeTaiList = this.xeTaiService.findAll();
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
                    System.out.print("Nhập biển kiểm soát oto.csv cần xoá: ");
                    int bienKiemSoat = Integer.parseInt(scanner.nextLine());
                    boolean isDeleted = this.xeTaiService.delete(bienKiemSoat);
                    if (isDeleted) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy xe tải có biển kiểm soát này!");
                    }
                    break;
                case FIND:
                    System.out.print("Nhập biển kiểm soát cần tìm: ");
                    int bienKiemSoatCanTim = Integer.parseInt(scanner.nextLine());
                    XeTai foundXeTai = xeTaiService.findByBienKiemSoat(bienKiemSoatCanTim);
                    if (foundXeTai != null) {
                        XeTaiView.display(foundXeTai);
                    } else {
                        System.out.println("Không tìm thấy xe với biển kiểm soát này.");
                    }
                    break;
                case UPDATE:
                    System.out.print("Nhập biển kiểm soát cần cập nhật: ");
                    int bienKiemSoatUpdate = Integer.parseInt(scanner.nextLine());
                    XeTai existingXeTai = xeTaiService.findByBienKiemSoat(bienKiemSoatUpdate);

                    if (existingXeTai != null) {
                        System.out.println("Nhập thông tin mới cho xe");
                        XeTai newXeTai = XeTaiView.inputDataForXeTai();
                        newXeTai.setBienKiemSoat(bienKiemSoatUpdate);

                        boolean isUpdated = xeTaiService.update(bienKiemSoatUpdate, newXeTai);
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
