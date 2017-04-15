package in.ideative.model;

import java.util.Date;

/**
 * Class for User entity
 *
 * Created by harshit on 14/4/17.
 */
public class User {
  private Integer id;
  private String firstName;
  private String lastName;
  private String name;
  private String email;
  private String password;
  private Date startDate;
  private Date endDate;
  private Integer status;

  /**
   * @return id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id
   *     the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName
   *     the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName
   *     the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

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
   * @return startDate
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * @param startDate
   *     the startDate to set
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  /**
   * @return endDate
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * @param endDate
   *     the endDate to set
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  /**
   * @return status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status
   *     the status to set
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name
   *     the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
}
