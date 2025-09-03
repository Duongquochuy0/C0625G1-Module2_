package furama_manage.view;

import furama_manage.entity.House;
import furama_manage.entity.Room;
import furama_manage.entity.Villa;
import furama_manage.util.UserInputException;
import furama_manage.util.Validating;

import java.util.Scanner;

public class CoSoVatChatView {
    private static final Scanner scanner = new Scanner(System.in);
    public static Villa nhapVilla() {
        String maDichVu = "";
        String tenDichVu = "";
        double dienTichSuDung = 0;
        double chiPhiThue = 0;
        int soLuongNguoiToiDa = 0;
        String kieuThue = "";
        String tieuChuanPhong = "";
        double dienTichHoBoi = 0;
        int soTang = 0;

        while (true) {
            try {
                System.out.println("Nhập Mã dịch vụ (SVVL-YYYY):");
                maDichVu = scanner.nextLine();
                Validating.validateFacilityId(maDichVu, "SVVL");
                break;
            } catch (UserInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Tên dịch vụ:");
                tenDichVu = scanner.nextLine();
                Validating.validateName(tenDichVu);
                break;
            } catch (UserInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Diện tích sử dụng (> 30m2):");
                dienTichSuDung = Double.parseDouble(scanner.nextLine());
                Validating.validateArea(dienTichSuDung);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Chi phí thuê (> 0):");
                chiPhiThue = Double.parseDouble(scanner.nextLine());
                Validating.validateCost(chiPhiThue);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Số lượng người tối đa (> 0 và < 20):");
                soLuongNguoiToiDa = Integer.parseInt(scanner.nextLine());
                Validating.validateMaxPeople(soLuongNguoiToiDa);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        System.out.println("Nhập Kiểu thuê:");
        kieuThue = scanner.nextLine();

        System.out.println("Nhập Tiêu chuẩn phòng:");
        tieuChuanPhong = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Nhập Diện tích hồ bơi (> 30m2):");
                dienTichHoBoi = Double.parseDouble(scanner.nextLine());
                Validating.validatePoolArea(dienTichHoBoi);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Số tầng (> 0):");
                soTang = Integer.parseInt(scanner.nextLine());
                Validating.validateFloors(soTang);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        return new Villa(maDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, tieuChuanPhong, dienTichHoBoi, soTang);
    }

    public static House nhapHouse() {
        String maDichVu = "";
        String tenDichVu = "";
        double dienTichSuDung = 0;
        double chiPhiThue = 0;
        int soLuongNguoiToiDa = 0;
        String kieuThue = "";
        String tieuChuanPhong = "";
        int soTang = 0;

        while (true) {
            try {
                System.out.println("Nhập Mã dịch vụ (SVHO-YYYY):");
                maDichVu = scanner.nextLine();
                Validating.validateFacilityId(maDichVu, "SVHO");
                break;
            } catch (UserInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Tên dịch vụ:");
                tenDichVu = scanner.nextLine();
                Validating.validateName(tenDichVu);
                break;
            } catch (UserInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Diện tích sử dụng (> 30m2):");
                dienTichSuDung = Double.parseDouble(scanner.nextLine());
                Validating.validateArea(dienTichSuDung);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Chi phí thuê (> 0):");
                chiPhiThue = Double.parseDouble(scanner.nextLine());
                Validating.validateCost(chiPhiThue);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Số lượng người tối đa (> 0 và < 20):");
                soLuongNguoiToiDa = Integer.parseInt(scanner.nextLine());
                Validating.validateMaxPeople(soLuongNguoiToiDa);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        System.out.println("Nhập Kiểu thuê:");
        kieuThue = scanner.nextLine();

        System.out.println("Nhập Tiêu chuẩn phòng:");
        tieuChuanPhong = scanner.nextLine();

        while (true) {
            try {
                System.out.println("Nhập Số tầng (> 0):");
                soTang = Integer.parseInt(scanner.nextLine());
                Validating.validateFloors(soTang);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }

        return new House(maDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, tieuChuanPhong, soTang);
    }

    public static Room nhapRoom() {
        String maDichVu = "";
        String tenDichVu = "";
        double dienTichSuDung = 0;
        double chiPhiThue = 0;
        int soLuongNguoiToiDa = 0;
        String kieuThue = "";
        String dichVuMienPhiDiKem = "";

        while (true) {
            try {
                System.out.println("Nhập Mã dịch vụ (SVRO-YYYY):");
                maDichVu = scanner.nextLine();
                Validating.validateFacilityId(maDichVu, "SVRO");
                break;
            } catch (UserInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Tên dịch vụ:");
                tenDichVu = scanner.nextLine();
                Validating.validateName(tenDichVu);
                break;
            } catch (UserInputException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Diện tích sử dụng (> 30m2):");
                dienTichSuDung = Double.parseDouble(scanner.nextLine());
                Validating.validateArea(dienTichSuDung);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Chi phí thuê (> 0):");
                chiPhiThue = Double.parseDouble(scanner.nextLine());
                Validating.validateCost(chiPhiThue);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập Số lượng người tối đa (> 0 và < 20):");
                soLuongNguoiToiDa = Integer.parseInt(scanner.nextLine());
                Validating.validateMaxPeople(soLuongNguoiToiDa);
                break;
            } catch (UserInputException | NumberFormatException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        }
        System.out.println("Nhập Kiểu thuê:");
        kieuThue = scanner.nextLine();

        System.out.println("Nhập Dịch vụ miễn phí đi kèm:");
        dichVuMienPhiDiKem = scanner.nextLine();

        return new Room(maDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, dichVuMienPhiDiKem);
    }
}
