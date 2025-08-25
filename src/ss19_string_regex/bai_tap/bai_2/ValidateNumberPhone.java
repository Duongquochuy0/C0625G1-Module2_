package ss19_string_regex.bai_tap.bai_2;

public class ValidateNumberPhone {
    public static boolean checkNumberPhone(String number){
        String numberCheck = "^(84)-0\\d{9}$";
        return number.matches(numberCheck);
    }
}
