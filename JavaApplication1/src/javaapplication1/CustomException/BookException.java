package javaapplication1.CustomException;

public class BookException extends Exception {

    public BookException() {
    }

    public BookException(String s) {
        super(s);
    }

    public BookException(Throwable cause) {
        super(cause);
    }

    public BookException(String message, Throwable cause) {
        super(message, cause);
    }

}
