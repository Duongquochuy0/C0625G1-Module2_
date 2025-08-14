package transportation_mannerger.view;
import transportation_mannerger.entity.XeMay;
import java.util.ArrayList;
import java.util.Scanner;

public class XeMayView {
    private static Scanner scanner = new Scanner(System.in);
    public static void disPlay(ArrayList<XeMay> xeMayList){
        for (XeMay xeMay: xeMayList) {
            System.out.println(xeMay);
        }
    }
    public static XeMay inputDataForXeMay(){

        System.out.println("Nhập biển kiểm soát: ");
        int bienKiemSoat = Integer.parseInt(scanner.nextLine());
        System.out.println(" Nhập hãng xe: ");
        String hangSanXuat = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Nhập Công Suất: ");
        int congSuat = scanner.nextInt();
        XeMay xeMay = new XeMay(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,congSuat);
        return xeMay;
    }
//
}
