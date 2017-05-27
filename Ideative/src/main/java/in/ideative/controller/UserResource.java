package in.ideative.controller;

import in.ideative.exception.ApplicationException;
import in.ideative.model.User;
import in.ideative.service.UserService;
import in.ideative.utils.AppResponse;
import in.ideative.utils.Constants;
import in.ideative.utils.Messages;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Resource class for User APIs
 *
 * Created by harshit on 15/4/17.
 */
@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
  private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

  @Autowired
  private UserService userService;

  /**
   * Method to get a user by userId
   * @param userId of the user
   * @return User
   */
  @GET
  public Response getUser(@QueryParam("userId") @NotNull Integer userId) {
    LOG.info("getUser - Method begins with userId <{}>", userId);
    if (userId <= 0) {
      throw new ApplicationException(HttpStatus.SC_BAD_REQUEST, Messages.BAD_REQUEST);
    }
    User user = new User(userId);
    user = userService.getUser(user);
    if (user == null) {
      throw new ApplicationException(HttpStatus.SC_BAD_REQUEST, Messages.INVALID_USER_ID);
    }
    return Response.ok().entity(user).build();
  }

  /**
   * Method to add a user
   * @param user details of the user
   * @return {@link Response}
   */
  @POST
  @Path("/add")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addUser(@HeaderParam(Constants.USER_ID) Integer userId, @NotNull @Valid User user) {
    LOG.info("addUser - Method begins with email <{}> userId <{}>", user.getEmail(), userId);
    if (!userService.validateUserData(user)){
      throw new ApplicationException(HttpStatus.SC_BAD_REQUEST, Messages.INVALID_USER_DETAILS);
    }
    int rows = userService.addUser(user);
    if (rows != 1){
      throw new ApplicationException(HttpStatus.SC_INTERNAL_SERVER_ERROR, Messages.USER_INSERTION_FAILED);
    }
    return Response.status(HttpStatus.SC_OK)
        .entity(new AppResponse(HttpStatus.SC_OK, Messages.USER_INSERTION_SUCCESSFUL, false))
        .build();
  }

}
