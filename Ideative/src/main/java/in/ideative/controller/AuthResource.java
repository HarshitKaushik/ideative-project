package in.ideative.controller;

import in.ideative.model.AuthRequest;
import in.ideative.model.User;
import in.ideative.service.UserService;
import in.ideative.utils.AppResponse;
import in.ideative.utils.Constants;
import in.ideative.utils.JSONUtil;
import in.ideative.utils.Messages;

import java.net.HttpURLConnection;

import javax.validation.Valid;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Resource class for User Authentication
 *
 * Created by harshit on 15/4/17.
 */
@Path(Constants.AUTH_RESOURCE_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
  private static final Logger LOG = LoggerFactory.getLogger(AuthResource.class);

  @Autowired
  private UserService userService;

  /**
   * Method to authenticate the user
   * @param authRequest with email, password and rememberMe
   * @return {@link Response}
   */
  @POST
  public Response authenticate(@HeaderParam(Constants.IP_ADDRESS) String ipAddress,
      @Valid AuthRequest authRequest) {
    LOG.info("authenticate - Method begins with email <{}>", authRequest.getEmail());
    if (!EmailValidator.getInstance().isValid(authRequest.getEmail())) {
      return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
          .entity(new AppResponse(HttpURLConnection.HTTP_BAD_REQUEST, Messages.INVALID_EMAIL, true))
          .build();
    }
    User user = userService.getUser(new User(authRequest.getEmail()));
    if (user == null) {
      return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
          .entity(new AppResponse(HttpURLConnection.HTTP_BAD_REQUEST, Messages.BAD_REQUEST, true))
          .build();
    }
    boolean authenticated = false;
    String accessToken = null;
    if (StringUtils.isNotBlank(user.getPassword()) && user.getPassword().equals(authRequest.getPassword())) {
      //User authenticated
      accessToken = RandomStringUtils.randomAlphanumeric(Constants.ACCESS_TOKEN_LENGTH);
      userService.insertUserLoginDetails(user, accessToken, ipAddress);
      authenticated = true;
    }
    if (!authenticated) {
      return Response.status(HttpURLConnection.HTTP_FORBIDDEN)
          .entity(new AppResponse(HttpURLConnection.HTTP_FORBIDDEN, Messages.USER_AUTHENTICATION_FAILED, true))
          .build();
    }
    return Response.ok(JSONUtil.objectToJson(accessToken))
        .build();
  }

}
