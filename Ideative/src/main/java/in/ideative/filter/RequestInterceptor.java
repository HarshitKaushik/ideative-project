package in.ideative.filter;

import in.ideative.model.User;
import in.ideative.service.UserService;
import in.ideative.utils.Constants;
import in.ideative.utils.Messages;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;

/**
 * Request Interceptor for all incoming classes
 *
 * Created by harshit on 8/4/17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestInterceptor implements Filter {
  private Logger log = LoggerFactory.getLogger(RequestInterceptor.class);

  @Autowired
  private UserService userService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    //Default init method
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    log.debug("Inside Request Filter");
    HttpServletRequest httpServletRequest = asHttp(request);
    HttpServletResponse httpServletResponse = asHttp(response);
    String resourcePath = new UrlPathHelper().getPathWithinApplication(httpServletRequest);
    if (resourcePath.contains(Constants.AUTH_RESOURCE_PATH) || !resourcePath.contains(Constants.PING_RESOURCE_PATH)) {
      chain.doFilter(request, response);
    } else {
      String accessToken = httpServletRequest.getHeader(Constants.ACCESS_TOKEN);
      if (accessToken == null) {
        httpServletResponse.sendError(HttpURLConnection.HTTP_BAD_REQUEST, Messages.BAD_REQUEST);
        return;
      }
      User user = userService.getUserByAccessToken(accessToken);
      if (user != null) {
        log.debug("doFilter - User <{}> authenticated successfully", user.getName());
        chain.doFilter(request, response);
      } else {
        httpServletResponse.sendError(HttpURLConnection.HTTP_BAD_REQUEST, Messages.BAD_REQUEST);
        return;
      }
    }
    log.debug("Inside Response Filter");
  }

  private HttpServletRequest asHttp(ServletRequest request) {
    return (HttpServletRequest) request;
  }

  private HttpServletResponse asHttp(ServletResponse response) {
    return (HttpServletResponse) response;
  }

  @Override
  public void destroy() {
    //Default destroyer
  }

}
