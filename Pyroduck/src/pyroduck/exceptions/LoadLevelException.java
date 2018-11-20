package pyroduck.exceptions;

/**
 * Exception related at the error in the level charged.
 * @author Bini
 */
public class LoadLevelException extends PyroduckException {
    public LoadLevelException() {
    }

    /**
     * Constructs a new exception with the specified detail message.
     * @param str detail message.
     */
    public LoadLevelException(String str) {
        super(str);
    }
}
