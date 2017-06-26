package in.ideative.controller;

import in.ideative.utils.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ping Resource class
 *
 * Created by harshit on 28/3/17.
 */
@Path("ping")
@Produces(MediaType.APPLICATION_JSON)
public class PingResource {
  private static final Logger LOG = LoggerFactory.getLogger(PingResource.class);

  /**
   * Method to ping API
   * @return {@link Response}
   */
  @GET
  public Response ping() {
    LOG.debug("ping - Method begins here");
    Map<String, String> pingResponse = new LinkedHashMap<>();
    pingResponse.put(Constants.VERSION, Constants.IDEATIVE_VERSION);
    pingResponse.put(Constants.CONTRIBUTOR, Constants.THE_DEV_FRATERNITY);
    pingResponse.put("More info at", Constants.IDEATIVE_REPOSITORY);
    return Response.ok(pingResponse).build();
  }
}
