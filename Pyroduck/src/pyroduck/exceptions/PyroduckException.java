package pyroduck.exceptions;

/**
 * Exception thrown when there is an error in Pyroduck.
 * @author all
 */
public class PyroduckException extends Exception {
    public PyroduckException() {
    }

    /**
     * Creates a new exception with the specified detail message.
     * @param str detail message.
     */
    public PyroduckException(String str) {
        super(str);
    }
}