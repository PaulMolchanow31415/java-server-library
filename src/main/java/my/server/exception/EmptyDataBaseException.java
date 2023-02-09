package my.server.exception;

public class EmptyDataBaseException extends IllegalBookDataException {
    public EmptyDataBaseException(String message) {
        super(message);
    }
}
