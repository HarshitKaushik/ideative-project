package in.ideative.filter;

import in.ideative.model.User;
import in.ideative.service.UserService;
import in.ideative.utils.Constants;
import in.ideative.utils.JSONUtil;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Filter for requests
 *
 * Created by harshit on 1/5/17.
 */
public class RequestFilter implements ContainerRequestFilter {
  private static final Logger LOG = LoggerFactory.getLogger(RequestFilter.class);

  @Context
  HttpServletRequest request;

  @Autowired
  private UserService userService;

  /**
   * Filter method
   * @param requestContext (of Jax-rs)
   * @throws IOException
   */
  @Override
  public void filter(ContainerRequestContext requestContext)
      throws IOException {
    LOG.debug("filter - Method begins here");
    String resourcePath = requestContext.getUriInfo().getPath();
    String ipAddress = request.getRemoteAddr();
    if (StringUtils.isBlank(ipAddress)) {
      ipAddress = request.getLocalAddr();
    }
    requestContext.getHeaders().add(Constants.IP_ADDRESS, ipAddress);
    if (!resourcePath.contains(Constants.AUTH_RESOURCE_PATH) && !resourcePath.contains(Constants.PING_RESOURCE_PATH)) {
      String accessToken = request.getHeader(Constants.ACCESS_TOKEN);
      if (accessToken == null) {
        requestContext.abortWith(Response
            .status(HttpURLConnection.HTTP_UNAUTHORIZED)
            .entity(JSONUtil.objectToJson("User cannot access the resource."))
            .build());
      }
      User user = userService.getUserByAccessToken(accessToken);
      if (user != null) {
        LOG.debug("filter - User <{}> authenticated successfully", user.getName());
        requestContext.getHeaders().add(Constants.USER_ID, user.getId().toString());
      } else {
        requestContext.abortWith(Response
            .status(HttpURLConnection.HTTP_UNAUTHORIZED)
            .entity(JSONUtil.objectToJson("User cannot access the resource."))
            .build());
      }
    }
  }
}
