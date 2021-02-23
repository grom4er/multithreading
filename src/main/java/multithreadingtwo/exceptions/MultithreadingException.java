package multithreadingtwo.exceptions;

public class MultithreadingException extends RuntimeException {
    public MultithreadingException(String message, Exception e) {
        super(message, e);
    }
}
