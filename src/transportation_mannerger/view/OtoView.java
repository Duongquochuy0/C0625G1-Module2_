package transportation_mannerger.view;

import transportation_mannerger.entity.Oto;
import transportation_mannerger.entity.XeMay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OtoView {
    private static Scanner scanner = new Scanner(System.in);
    public static void disPlay(List<Oto> otoList){
        for (Oto oto: otoList) {
            System.out.println(oto);
        }
    }
    public static Oto inputDataForOto(){
        System.out.println("Nhập biển kiểm soát: ");
        int bienKiemSoat = Integer.parseInt(scanner.nextLine());
        System.out.println(" Nhập hãng xe: ");
        String hangSanXuat = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Nhập số chỗ ngồi: ");
        int soChoNgoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu xe: ");
        String kieuXe= scanner.nextLine();
        Oto oto = new Oto(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu,soChoNgoi,kieuXe);
        return oto;
    }
    public static void display(Oto oto) {
        System.out.println(oto);
    }

}
