package quan_ly_bo_de_thi.util;

import quan_ly_bo_de_thi.entity.CauHoi;
import quan_ly_bo_de_thi.entity.DapAn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateDuplicateQuestionId(String qid, List<CauHoi> cauHois) throws InvalidDataException {
        for (CauHoi cauHoi : cauHois) {
            if (cauHoi.getMaCauHoi().equals(qid)) {
                throw new InvalidDataException("Mã câu hỏi " + qid + " đã tồn tại!");
            }
        }
    }
    public static void validateQuestionIdFormat(String qid) throws InvalidDataException {
        if (!qid.matches("^Q\\d{3}$")) {
            throw new InvalidDataException("Mã câu hỏi " + qid + " không hợp lệ! (Định dạng đúng: Qxxx)");
        }
    }
    public static void validateQuestionContent(String content) throws InvalidDataException {
        if (content == null || content.trim().isEmpty()) {
            throw new InvalidDataException("Nội dung câu hỏi không được để trống");
        }
    }
    public static void validateAnswerCount(CauHoi cauHoi) throws InvalidDataException {
        if (cauHoi.getDapAns().size() != 4) {
            throw new InvalidDataException("Câu hỏi " + cauHoi.getMaCauHoi() + " phải có đúng 4 đáp án");
        }
    }
    public static void validateAnswerIdFormat(String aid) throws InvalidDataException {
        if (!aid.matches("^A\\d{3}$")) {
            throw new InvalidDataException("Mã đáp án " + aid + " không hợp lệ! (Định dạng đúng: Axxx)");
        }
    }

    public static void validateAnswerContent(String content, String aid) throws InvalidDataException {
        if (content == null || content.trim().isEmpty()) {
            throw new InvalidDataException("Nội dung đáp án " + aid + " không được để trống!");
        }
    }
    public static void validateAnswerCorrectInput(String input) throws InvalidDataException {
        if (!input.equalsIgnoreCase("true") && !input.equalsIgnoreCase("false")) {
            throw new InvalidDataException("Giá trị phải là true hoặc false");
        }
    }
    public static void validateAnswers(CauHoi cauHoi) throws InvalidDataException {
        Set<String> ids = new HashSet<>();
        for (DapAn a : cauHoi.getDapAns()) {
            if (!ids.add(a.getMaDapAn())) {
                throw new InvalidDataException("Mã đáp án " + a.getMaDapAn()
                        + " bị trùng trong câu hỏi " + cauHoi.getMaCauHoi());
            }
            validateAnswerIdFormat(a.getMaDapAn());
            validateAnswerContent(a.getNoiDungDapAn(), a.getMaDapAn());
        }
    }

    public static void validateQuestion(CauHoi cauHoi, List<CauHoi> cauHois) throws InvalidDataException {
        validateQuestionIdFormat(cauHoi.getMaCauHoi());
        validateDuplicateQuestionId(cauHoi.getMaCauHoi(), cauHois);
        validateQuestionContent(cauHoi.getNoiDungCauHoi());
        validateAnswerCount(cauHoi);
        validateAnswers(cauHoi);

    }
}
