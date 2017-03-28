package in.ideative.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ping Resource class
 *
 * Created by harshit on 28/3/17.
 */
@Path("ping")
public class PingResource {
  private Logger logger = LoggerFactory.getLogger(PingResource.class);

  @GET
  public Response ping() {
    logger.info("ping - Method begins here");
    String x = "Hello World";
    logger.debug("ping - <{}>", x);
    return Response.ok().build();
  }
}
