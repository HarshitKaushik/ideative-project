package in.ideative.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for String validation
 * Created by eramit95 on 5/14/2017.
 */
public class StringUtil {
  public static boolean validateName(String txt) {
    String regx = "^[a-zA-Z\\s]*$";
    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(txt);
    return matcher.find();
  }
}
