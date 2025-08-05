package ss2_loop.bai_tap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chon;
        final int HINHCHUNHAT = 1;
        final int TAMGIACVUONG = 2;
        final int TAMGIACCAN = 3;
        final int EXIT = 4;

        do {
            System.out.println("------ Menu ------");
            System.out.println("1. In hình chữ nhật");
            System.out.println("2. In hình tam giác vuông");
            System.out.println("3. In hình tam giác cân");
            System.out.println("4. Thoát");
            chon = scanner.nextInt();

            switch (chon) {
                case HINHCHUNHAT:
                    inHinhChuNhat(scanner);
                    break;
                case TAMGIACVUONG:
                    inHinhTamGiac(scanner);
                    break;
                case TAMGIACCAN:
                    inTamGiacCan(scanner);
                    break;
                case EXIT:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != EXIT);
    }

    public static void inHinhChuNhat(Scanner scanner) {
        System.out.print("Nhập chiều dài: ");
        int dai = scanner.nextInt();
        System.out.print("Nhập chiều rộng: ");
        int rong = scanner.nextInt();

        for (int i = 0; i < dai; i++) {
            for (int j = 0; j < rong; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void inHinhTamGiac(Scanner scanner) {
        System.out.print("Nhập chiều cao tam giác: ");
        int cao = scanner.nextInt();

        System.out.println("Chọn kiểu tam giác vuông:");
        System.out.println("1. Vuông trên trái");
        System.out.println("2. Vuông trên phải");
        System.out.println("3. Vuông dưới trái");
        System.out.println("4. Vuông dưới phải");
        System.out.print("Chọn: ");
        int tamGiac = scanner.nextInt();

        switch (tamGiac) {
            case 1:
                for (int i = cao; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = cao; i >= 1; i--) {
                    for (int j = 1; j <= cao - i; j++) {
                        System.out.print("  ");
                    }
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = 1; i <= cao; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 4:
                for (int i = 1; i <= cao; i++) {
                    for (int j = 1; j <= cao - i; j++) {
                        System.out.print("  ");
                    }
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    public static void inTamGiacCan(Scanner scanner) {
        System.out.print("Nhập chiều cao: ");
        int cao = scanner.nextInt();

        for (int i = 1; i <= cao; i++) {
            for (int j = 1; j <= cao - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
