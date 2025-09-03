package furama_manage.util;

import java.time.LocalDate;
import java.time.Period;

public class Validating {
    private static final String EMPLOYEE_ID_REGEX = "^NV-\\d{4}$";
    private static final String CUSTUMER_ID_REGEX = "^KH-\\d{4}$";
    private static final String NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String ID_CARD_REGEX = "^\\d{9}|\\d{12}$";
    private static final String PHONE_NUMBER_REGEX = "^0\\d{9}$";
    private static final String GENDER_REGEX = "^(Male|Female)$";
    private static final String LOAI_KHACH_REGEX = "^(Diamond|Platinium|Gold|Silver|Member)$";
    // Regex cho mã dịch vụ
    private static final String FACILITY_ID_REGEX = "^(SVVL|SVHO|SVRO)-\\d{4}$";

    public static void validateEmployeeId(String id) throws UserInputException {
        if (!id.matches(EMPLOYEE_ID_REGEX)) {
            throw new UserInputException("Mã nhân viên phải đúng định dạng NV-YYYY");
        }
    }

    public static void validateName(String name) throws UserInputException {
        if (!name.matches(NAME_REGEX)) {
            throw new UserInputException("Tên phải viết hoa chữ cái đầu tiên của mỗi từ");
        }
    }

    public static void validateAge(LocalDate dateOfBirth) throws UserInputException {
        if (Period.between(dateOfBirth, LocalDate.now()).getYears() < 18) {
            throw new UserInputException("Tuổi phải lớn hơn hoặc bằng 18");
        }
    }

    public static void validateGender(String gender) throws UserInputException {
        if (!gender.matches(GENDER_REGEX)) {
            throw new UserInputException("Giới tính không hợp lệ. Vui lòng chọn Male, Female");
        }
    }

    public static void validateIdCard(String idCard) throws UserInputException {
        if (!idCard.matches(ID_CARD_REGEX)) {
            throw new UserInputException("Số CMND phải có 9 hoặc 12 số.");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) throws UserInputException {
        if (!phoneNumber.matches(PHONE_NUMBER_REGEX)) {
            throw new UserInputException("Số điện thoại phải bắt đầu bằng 0 và có 10 số");
        }
    }

    public static void validateEmail(String email) throws UserInputException {
        if (!email.matches(EMAIL_REGEX)) {
            throw new UserInputException("Email không đúng định dạng");
        }
    }

    public static void validateSalary(double salary) throws UserInputException {
        if (salary <= 0) {
            throw new UserInputException("Lương phải lớn hơn 0");
        }
    }
    public static void validateCustumerId(String id) throws UserInputException {
        if (!id.matches(CUSTUMER_ID_REGEX)) {
            throw new UserInputException("Mã khách hàng phải đúng định dạng KH-YYYY");
        }
    }

    public static void validateCustomerType(String loaiKhach) throws UserInputException {
        if (!loaiKhach.matches(LOAI_KHACH_REGEX)) {
            throw new UserInputException("Loại khách hàng không hợp lệ");
        }
    }

    // Các phương thức bổ sung cho Task 5
    public static void validateFacilityId(String id, String prefix) throws UserInputException {
        if (!id.matches("^" + prefix + "-\\d{4}$")) {
            throw new UserInputException("Mã dịch vụ phải đúng định dạng " + prefix + "-YYYY");
        }
    }

    public static void validateArea(double area) throws UserInputException {
        if (area <= 30) {
            throw new UserInputException("Diện tích sử dụng phải lớn hơn 30m2");
        }
    }

    public static void validateCost(double cost) throws UserInputException {
        if (cost <= 0) {
            throw new UserInputException("Chi phí thuê phải là số dương");
        }
    }

    public static void validateMaxPeople(int maxPeople) throws UserInputException {
        if (maxPeople <= 0 || maxPeople >= 20) {
            throw new UserInputException("Số lượng người tối đa phải lớn hơn 0 và nhỏ hơn 20");
        }
    }

    public static void validateFloors(int floors) throws UserInputException {
        if (floors <= 0) {
            throw new UserInputException("Số tầng phải là số dương");
        }
    }

    public static void validatePoolArea(double poolArea) throws UserInputException {
        if (poolArea <= 30) {
            throw new UserInputException("Diện tích hồ bơi phải lớn hơn 30m2");
        }
    }
}
