package in.ideative.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Utility class for JSON-related operations
 *
 * Created by harshit on 30/4/17.
 */
public class JSONUtil {
  private static final Logger LOG = LoggerFactory.getLogger(JSONUtil.class);

  private JSONUtil() {
    //Default constructor
  }

  public static String objectToJson(Object object) {
    LOG.debug("objectToJson - Method begins here");
    String json = null;
    try {
      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
      json = ow.writeValueAsString(object);
      LOG.debug("objectToJson - The JSON <{}>", json);
    } catch (JsonProcessingException e) {
      LOG.error("objectToJson - Exception occured <{}>", ExceptionUtils.getStackTrace(e));
    }
    return json;
  }
}
