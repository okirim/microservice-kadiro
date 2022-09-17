package kadiro.com.exceptions;


import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException{
    private final int status;

    public AppException(String message, int httpStatus) {
        super(message);
        this.status = httpStatus;
    }

    public int getStatus() {
        return status;
    }
}