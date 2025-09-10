package quan_ly_bo_de_thi.view;

import quan_ly_bo_de_thi.entity.DapAn;
import quan_ly_bo_de_thi.util.InvalidDataException;
import quan_ly_bo_de_thi.util.Validator;

import java.util.List;
import java.util.Scanner;

public class DapAnView {
    private static Scanner scanner = new Scanner(System.in);

    public static void display(List<DapAn> dapAnList) {
        for (DapAn dapAn : dapAnList) {
            dapAn.display();
        }
    }

    public static DapAn inputDataDapAn(String maCauHoi) {
        String maDapAn;
        String noiDungDapAn;
        boolean dapAnDung;
        while (true) {
            System.out.print("Nhập mã đáp án : ");
            maDapAn = scanner.nextLine();
            try {
                Validator.validateAnswerIdFormat(maDapAn);
                break;
            } catch (InvalidDataException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            System.out.print("Nhập nội dung đáp án: ");
            noiDungDapAn = scanner.nextLine();
            try {
                Validator.validateAnswerContent(noiDungDapAn, maDapAn);
                break;
            } catch (InvalidDataException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        while (true) {
            System.out.print("Đáp án này có đúng không? (true/false): ");
            String input = scanner.nextLine().trim();
            try {
                Validator.validateAnswerCorrectInput(input);
                dapAnDung = Boolean.parseBoolean(input);
                break;
            } catch (InvalidDataException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }

        return new DapAn(maCauHoi, maDapAn, noiDungDapAn, dapAnDung);
    }

    public static void display(DapAn dapAn) {
        dapAn.display();
    }
}
