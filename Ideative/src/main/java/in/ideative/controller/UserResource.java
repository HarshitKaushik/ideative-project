package in.ideative.controller;

import in.ideative.model.User;
import in.ideative.service.UserService;
import in.ideative.utils.AppResponse;
import in.ideative.utils.Constants;
import in.ideative.utils.Messages;

import java.net.HttpURLConnection;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Resource class for User APIs
 *
 * Created by harshit on 15/4/17.
 */
@Path(Constants.USER_RESOURCE_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
  private static final Logger log = LoggerFactory.getLogger(UserResource.class);

  @Autowired
  private UserService userService;

  /**
   * Method to get a user by userId
   * @param userId of the user
   * @return User
   */
  @GET
  public Response getUser(@QueryParam("userId") @NotNull Integer userId) {
    log.info("getUser - Method begins with userId <{}>", userId);
    if (userId <= 0) {
      return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
          .entity(new AppResponse(HttpURLConnection.HTTP_BAD_REQUEST, Messages.BAD_REQUEST, true))
          .build();
    }
    User user = new User(userId);
    user = userService.getUser(user);
    if (user == null) {
      return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
          .entity(new AppResponse(HttpURLConnection.HTTP_BAD_REQUEST, Messages.INVALID_USER_ID, true))
          .build();
    }
    return Response.ok().entity(user).build();
  }

}
