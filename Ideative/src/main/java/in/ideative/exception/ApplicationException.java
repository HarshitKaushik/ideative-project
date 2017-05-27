package in.ideative.exception;

import in.ideative.utils.AppResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Application Exception class
 */
public class ApplicationException extends WebApplicationException {

  /**
   * Parameterised constructor
   * @param status the response status
   * @param message response message
   */
  public ApplicationException(Integer status, String message) {
    super(Response.status(status).entity(new AppResponse(status, message, true))
        .type(MediaType.APPLICATION_JSON).build());
  }
}