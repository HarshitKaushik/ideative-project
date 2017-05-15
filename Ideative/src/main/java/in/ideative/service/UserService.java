package in.ideative.service;

import in.ideative.model.User;

/**
 * Service class for user entity
 *
 * Created by harshit on 14/4/17.
 */
public interface UserService {

  /**
   * Method to get the user by access token
   * @param accessToken a randomly generated accessToken
   * @return user if exists in database with the given access token
   */
  User getUserByAccessToken(String accessToken);

  /**
   * Method to get the user from id/email
   * @param user with id or email
   * @return user details
   */
  User getUser(User user);

  /**
   * Method to insert user login details
   * @param user with email and password
   * @param accessToken access token
   * @param ipAddress IP address
   */
  int insertUserLoginDetails(User user, String accessToken, String ipAddress);

  /**
   * Method to add user
   * @param user with user details
   * @return number of updated rows
   */
  int addUser(User user);

  /**
   * Service method to validate user data
   * @param user
   * @return boolean
   */
  boolean validateUserData(User user);
}
