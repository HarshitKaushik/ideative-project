package in.ideative.config;

import in.ideative.controller.PingResource;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Main config class for Jersey Configuration
 *
 * Created by harshit on 28/3/17.
 */
@Component
@ApplicationPath("/v1/api")
public class JerseyConfig extends ResourceConfig {

  /**
   * Constructor to register resource controllers which
   * serve as end points to our main application
   */
  public JerseyConfig() {
    register(PingResource.class);
  }
}
