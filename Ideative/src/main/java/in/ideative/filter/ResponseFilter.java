package in.ideative.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Filter class for responses
 *
 * Created by harshit on 8/4/17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResponseFilter implements Filter {
  private Logger log = LoggerFactory.getLogger(ResponseFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    chain.doFilter(request,response);
    log.debug("Inside Response Filter");
  }

  @Override
  public void destroy() {

  }
}
