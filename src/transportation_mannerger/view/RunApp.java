package transportation_mannerger.view;

import transportation_mannerger.controller.OtoController;
import transportation_mannerger.controller.XeMayController;
import transportation_mannerger.controller.XeTaiController;

import java.util.Scanner;

public class RunApp {
    public static void main(String[] args) {
    displayMain();
    }
    public static   void displayMain(){
        OtoController otoController = new OtoController();
        XeMayController xeMayController = new XeMayController();
        XeTaiController xeTaiController = new XeTaiController();
        Scanner scanner = new Scanner(System.in);
        final int XEMAY = 1;
        final int OTO = 2;
        final int XETAI = 3;
        boolean flag = true;
        while (flag) {
            System.out.println("Chọn đối tượng quản lý");
            System.out.println("-------Chức năng------" +
                    "\n 1. Quản lý xe máy" +
                    "\n 2. Quản lý oto.csv" +
                    "\n 3. Quản lý xe tải" +
                    "\n 4. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case XEMAY:
                    System.out.println("----Đây là chức năng quản lý xe máy----------");
                    xeMayController.displayMenu();
                    break;
                case OTO:
                    System.out.println("----Đây là chức năng quản lý oto.csv----------");
                    otoController.displayMenu();
                    break;
                case XETAI:
                    System.out.println("----Đây là chức năng quản lý xe tải----------");
                    xeTaiController.displayMenu();
                default:
                    flag = false;
            }
        }
    }
}
