package in.ideative.controller;

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
  private Logger log = LoggerFactory.getLogger(PingResource.class);

  @GET
  public Response ping() {
    log.info("ping - Method begins here");
    Map<String, String> pingResponse = new LinkedHashMap<>();
    pingResponse.put("Version", "1.0");
    pingResponse.put("Contributor", "The Dev Fraternity");
    return Response.ok(pingResponse).build();
  }
}
