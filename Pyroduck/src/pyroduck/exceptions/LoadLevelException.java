package pyroduck.exceptions;

/**
  * Exception thrown when there is the loading of the level from the file.
 * @author all
 */
public class LoadLevelException extends PyroduckException {
    public LoadLevelException() {
    }

    /**
     * Creates a new exception with specified details of the message.
     * @param str detail message.
     */
    public LoadLevelException(String str) {
        super(str);
    }
}