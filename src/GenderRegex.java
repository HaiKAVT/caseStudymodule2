import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenderRegex {
    private static final String gender = "^[Nn][Aa][Mm]+|[Nn][Uu]$";

    public static boolean validate(String gioiTinhNV){
        Pattern pattern = Pattern.compile(gender);
        Matcher matcher = pattern.matcher(gioiTinhNV);
        return matcher.matches();
    }
}
