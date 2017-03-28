package in.ideative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Real magic begins here
 *
 * Main class for Ideative Application
 *
 * Created by harshit on 28/3/17.
 */
@SpringBootApplication
public class ApiApplication {

  ApiApplication() {}

  /**
   * Main method to start the application
   * @param args command line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(ApiApplication.class, args);
  }

}