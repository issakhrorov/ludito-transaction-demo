package ludito.demo_transaction.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
  private static final Logger logger = LogManager.getLogger("LoggedExceptions");

  public static RuntimeException LoggedError(RuntimeException ex) {
    System.out.println("EXCEPTION LOG: ${ex.javaClass.simpleName} with message: ${ex.message}");
    logger.error("EXCEPTION LOG: ${ex.javaClass.simpleName} with message: ${ex.message}");
    return ex;
  }
}
