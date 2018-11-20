package pyroduck.exceptions;

/**
 * Exception related at the error within Pyroduck.
 * @author Bini
 */
public class PyroduckException extends Exception {
    public PyroduckException() {
    }

    /**
     * Constructs a new exception with the specified detail message.
     * @param str detail message.
     */
    public PyroduckException(String str) {
        super(str);
    }
}