package my.server.exception;

public class IllegalBookTitleException extends IllegalBookDataException {
    public IllegalBookTitleException(String message) {
        super(message);
    }
}
