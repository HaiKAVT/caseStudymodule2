import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameRegex {
    private static final String name = "^[A-Za-z]+$";


    public static boolean validate(String namenv){
        Pattern pattern = Pattern.compile(name);
        Matcher matcher = pattern.matcher(namenv);
        return matcher.matches();
    }
}
