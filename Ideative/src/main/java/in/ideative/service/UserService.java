package in.ideative.service;

import in.ideative.dao.UserDao;
import in.ideative.model.User;

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
  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserDao userDao;

  /**
   * Method to get the user by access token
   * @param accessToken a randomly generated accessToken
   * @return user if exists in database with the given access token
   */
  public User getUserByAccessToken(String accessToken) {
    log.debug("getUserByAccessToken - Method begins here");
    return userDao.getUserByAccessToken(accessToken);
  }

  /**
   * Method to get the user from id/email
   * @param user with id or email
   * @return user details
   */
  public User getUser(User user) {
    log.debug("getUser - Method begins with id <{}>, email <{}>", user.getId(), user.getName());
    return userDao.getUser(user);
  }
}
