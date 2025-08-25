package ss19_string_regex.bai_tap.bai_1;

public class Validate {
    public static boolean CheckNameClass(String name){
        String nameCheck ="^(C|A|P)\\d{4}(G|H|I|K)$";
        return name.matches(nameCheck);
    }
}
