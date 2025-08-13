package transportation_mannerger.controller;

import transportation_mannerger.entity.Oto;
import transportation_mannerger.service.IOtoService;
import transportation_mannerger.service.OtoService;
import transportation_mannerger.view.OtoView;

import java.util.ArrayList;
import java.util.Scanner;

public class OtoController {
private IOtoService otoService = new OtoService();
public void displayMenu(){
    Scanner scanner = new Scanner(System.in);
    final int DISPLAY = 1;
    final int ADD = 2;
    final int DELETE = 3;
    boolean flag =true;
    while (flag){
        System.out.println("Quản lý Oto");
        System.out.println("-------Chức năng------" +
                "\n 1. Danh sách các oto" +
                "\n 2. Thêm mới oto" +
                "\n 3. Xoá" +
                "\n 4. Quay lại" );

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
                break;
            default:
                flag = false;
        }
    }
}
}
