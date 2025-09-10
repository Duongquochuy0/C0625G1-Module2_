package quan_ly_bo_de_thi.view;

import quan_ly_bo_de_thi.entity.CauHoi;
import quan_ly_bo_de_thi.util.InvalidDataException;
import quan_ly_bo_de_thi.util.Validator;

import java.util.List;
import java.util.Scanner;

public class CauHoiView {
    private static Scanner scanner = new Scanner(System.in);
    public static void display(List<CauHoi> cauHoiList) {
        for (CauHoi cauHoi : cauHoiList) {
            cauHoi.display();
        }
    }
    public static CauHoi inputDataCauHoi() {
        String maCauHoi;
        String noiDungCauHoi;

        while (true) {
            try {
                System.out.print("Nhập mã câu hỏi: ");
                maCauHoi = scanner.nextLine();
                Validator.validateQuestionIdFormat(maCauHoi);
                break;
            } catch (InvalidDataException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhập nội dung câu hỏi: ");
                noiDungCauHoi = scanner.nextLine();
                if (noiDungCauHoi.trim().isEmpty()) {
                    throw new InvalidDataException("Nội dung câu hỏi không được để trống!");
                }
                break;
            } catch (InvalidDataException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }

        return new CauHoi(maCauHoi, noiDungCauHoi);
    }
    public static void display(CauHoi cauHoi) {
        cauHoi.display();
    }
}
