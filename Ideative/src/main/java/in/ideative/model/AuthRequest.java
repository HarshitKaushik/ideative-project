package in.ideative.model;

import javax.validation.constraints.NotNull;

/**
 * Model class for auth requests
 * Created by harshit on 22/4/17.
 */
public class AuthRequest {
  @NotNull
  private String email;
  @NotNull
  private String password;
  private boolean rememberMe;

  /**
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email
   *     the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password
   *     the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return rememberMe
   */
  public boolean isRememberMe() {
    return rememberMe;
  }

  /**
   * @param rememberMe
   *     the rememberMe to set
   */
  public void setRememberMe(boolean rememberMe) {
    this.rememberMe = rememberMe;
  }
}
