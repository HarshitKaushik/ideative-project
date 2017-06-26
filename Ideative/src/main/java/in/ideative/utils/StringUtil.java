package in.ideative.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for String validation
 * Created by eramit95 on 5/14/2017.
 */
public class StringUtil {
  private static final Logger LOG = LoggerFactory.getLogger(StringUtil.class);

  private StringUtil() {
    //Default constructor
  }

  /**
   * Method to validate a name of a person
   * @param name of the person
   * @return true/false
   */
  public static boolean validateName(String name) {
    LOG.debug("validateName - Method begins here with name <{}>", name);
    String regx = "^[a-zA-Z\\s]*$";
    Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(name);
    return matcher.find();
  }
}
