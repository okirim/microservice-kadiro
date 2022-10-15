package kadiro.com.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //List<String> errorsList = new ArrayList<>();
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();
//        if (errors.size() > 0) {
//            errorsList.addAll(errors);
//        } else {
//            var error = Objects.requireNonNull(ex.getGlobalError()).getDefaultMessage();
//            errorsList.add(error);
//        }
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMessage(HttpStatus.BAD_REQUEST.toString());
        errorDetails.setError(errors);
        errorDetails.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMessage(HttpStatus.BAD_REQUEST.toString());
        errorDetails.setError(List.of(ex.getParameterName() + " parameter is missing"));
        errorDetails.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(status.value());
        errorDetails.setMessage(status.toString());
        errorDetails.setError(List.of(ex.getMessage()));
        errorDetails.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorDetails, headers, status);
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(IOException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetails.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorDetails.setError(List.of(ex.getMessage()));
        errorDetails.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorDetails> handleAppException(AppException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(ex.getStatus());
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setError(Collections.singletonList(ex.getMessage()));
        errorDetails.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.valueOf(ex.getStatus()));
    }
    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ErrorDetails> handleSignatureException(SignatureException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorDetails.setMessage(HttpStatus.UNAUTHORIZED.toString());
        errorDetails.setError(List.of(ex.getMessage()));
        errorDetails.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetails.setMessage(HttpStatus.NOT_FOUND.toString());
        errorDetails.setError(Collections.singletonList(ex.getMessage()));
        errorDetails.setPath(request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
