package exceptions;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMoveException(String message) {
        super(message);
    }
}
