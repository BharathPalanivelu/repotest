package twitter4j;

import java.util.logging.Level;
import java.util.logging.Logger;

final class JULLogger extends Logger {
    private final Logger LOGGER;

    JULLogger(Logger logger) {
        this.LOGGER = logger;
    }

    public boolean isDebugEnabled() {
        return this.LOGGER.isLoggable(Level.FINE);
    }

    public boolean isInfoEnabled() {
        return this.LOGGER.isLoggable(Level.INFO);
    }

    public boolean isWarnEnabled() {
        return this.LOGGER.isLoggable(Level.WARNING);
    }

    public boolean isErrorEnabled() {
        return this.LOGGER.isLoggable(Level.SEVERE);
    }

    public void debug(String str) {
        this.LOGGER.fine(str);
    }

    public void debug(String str, String str2) {
        Logger logger = this.LOGGER;
        logger.fine(str + str2);
    }

    public void info(String str) {
        this.LOGGER.info(str);
    }

    public void info(String str, String str2) {
        Logger logger = this.LOGGER;
        logger.info(str + str2);
    }

    public void warn(String str) {
        this.LOGGER.warning(str);
    }

    public void warn(String str, String str2) {
        Logger logger = this.LOGGER;
        logger.warning(str + str2);
    }

    public void error(String str) {
        this.LOGGER.severe(str);
    }

    public void error(String str, Throwable th) {
        Logger logger = this.LOGGER;
        logger.severe(str + th.getMessage());
    }
}
