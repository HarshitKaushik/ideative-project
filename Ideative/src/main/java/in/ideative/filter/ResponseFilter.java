package in.ideative.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Filter for responses
 *
 * Created by harshit on 1/5/17.
 */
public class ResponseFilter implements ContainerResponseFilter {
  private static final Logger log = LoggerFactory.getLogger(ResponseFilter.class);

  /**
   * Filter method
   * @param responseContext
   * @param requestContext
   * @throws IOException
   */
  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
      throws IOException {
    log.debug("filter - Method begins here");
  }
}
