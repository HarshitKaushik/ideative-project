package in.ideative.service;

import in.ideative.dao.UserDao;
import in.ideative.model.User;
import in.ideative.utils.JSONUtil;
import in.ideative.utils.StringUtil;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for user entity
 *
 * Created by harshit on 14/4/17.
 */
@Service
public class UserService {
  private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserDao userDao;

  /**
   * Method to get the user by access token
   * @param accessToken a randomly generated accessToken
   * @return user if exists in database with the given access token
   */
  public User getUserByAccessToken(String accessToken) {
    LOG.debug("getUserByAccessToken - Method begins here");
    return userDao.getUserByAccessToken(accessToken);
  }

  /**
   * Method to get the user from id/email
   * @param user with id or email
   * @return user details
   */
  public User getUser(User user) {
    LOG.debug("getUser - Method begins with id <{}>, email <{}>", user.getId(), user.getEmail());
    return userDao.getUser(user);
  }

  /**
   * Method to insert user login details
   * @param user with email and password
   * @param accessToken access token
   * @param ipAddress IP address
   */
  public int insertUserLoginDetails(User user, String accessToken, String ipAddress) {
    LOG.debug("insertUserLoginDetails - Method begins with userId <{}>, accessToken <{}> and ipAddress <{}>", user.getId(), accessToken, ipAddress);
    user.setAccessToken(accessToken);
    user.setIpAddress(ipAddress);
    return userDao.insertUserLoginDetails(user);
  }

  /**
   * Method to add user
   * @param user with user details
   * @return number of updated rows
   */
  public int addUser(User user){
    LOG.debug("addUser - Method begins email <{}>", user.getEmail());
      return userDao.addUser(user);
  }

  /**
   * Service method to validate user data
   * @param user
   * @return boolean
   */
  public boolean validateUserData(User user) {
    LOG.debug("validateUserData - Method begins <{}>", JSONUtil.objectToJson(user));
    if (!StringUtil.validateName(user.getFirstName())) {
      return false;
    }
    return !(StringUtils.isNotBlank(user.getLastName()) && !StringUtil.validateName(user.getLastName()));
  }
}
