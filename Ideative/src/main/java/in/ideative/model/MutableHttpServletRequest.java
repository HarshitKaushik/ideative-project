package in.ideative.model;

import in.ideative.utils.JSONUtil;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Decorator class for HttpServletRequest
 *
 * Created by harshit on 22/4/17.
 */
public class MutableHttpServletRequest extends HttpServletRequestWrapper {
  private static final Logger log = LoggerFactory.getLogger(MutableHttpServletRequest.class);
  // holds custom header and value mapping
  private final Map<String, String> customHeaders;

  public MutableHttpServletRequest(HttpServletRequest request){
    super(request);
    this.customHeaders = new HashMap<>();
  }

  public void putHeader(String name, String value){
    this.customHeaders.put(name, value);
  }

  @Override
  public String getHeader(String name) {
    log.debug("pokemon - <{}>", JSONUtil.objectToJson(customHeaders));
    // check the custom headers first
    String headerValue = customHeaders.get(name);

    if (headerValue != null){
      return headerValue;
    }
    // else return from into the original wrapped object
    return ((HttpServletRequest) getRequest()).getHeader(name);
  }

  @Override
  public Enumeration<String> getHeaderNames() {
    // create a set of the custom header names
    Set<String> set = new HashSet<>(customHeaders.keySet());

    // now add the headers from the wrapped request object
    @SuppressWarnings("unchecked")
    Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
    while (e.hasMoreElements()) {
      // add the names of the request headers into the list
      String n = e.nextElement();
      set.add(n);
    }

    // create an enumeration from the set and return
    return Collections.enumeration(set);
  }
}
