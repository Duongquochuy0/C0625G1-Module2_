package transportation_mannerger.view;
import transportation_mannerger.entity.Oto;
import transportation_mannerger.entity.XeMay;
import transportation_mannerger.entity.XeTai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeTaiView {
    private static Scanner scanner = new Scanner(System.in);
    public static void disPlay(List<XeTai> xeTaiList){
        for (XeTai xeTai: xeTaiList) {
            System.out.println(xeTai);
        }
    }
    public static XeTai inputDataForXeTai(){

        System.out.println("Nhập biển kiểm soát: ");
        int bienKiemSoat = Integer.parseInt(scanner.nextLine());
        System.out.println(" Nhập hãng xe: ");
        String hangSanXuat = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Nhập trọng tải: ");
        int trongTai = scanner.nextInt();
        XeTai xeTai = new XeTai(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,trongTai);
        return xeTai;
    }
    public static void display(XeTai xeTai) {
        System.out.println(xeTai);
    }
}
