package utilities;

import java.util.logging.*;

public class Logging {
    private static Logger logger = Logger.getLogger(Logging.class.getName());

    public static void info(String message) {
        logger.log(Level.INFO, message);
    }

    public static void error(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }

    public static void debug(String message) {
        logger.log(Level.FINE, message);
    }
}
