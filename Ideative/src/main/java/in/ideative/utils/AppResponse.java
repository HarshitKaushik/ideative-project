package in.ideative.utils;

/**
 *  App Response object
 *
 * Created by harshit on 15/4/17.
 */
public class AppResponse {
  private int code;
  private String message;
  private boolean error;

  /**
   * @return code
   */
  public int getCode() {
    return code;
  }

  /**
   * @param code
   *     the code to set
   */
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * @return message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message
   *     the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return error
   */
  public boolean isError() {
    return error;
  }

  /**
   * @param error
   *     the error to set
   */
  public void setError(boolean error) {
    this.error = error;
  }
}