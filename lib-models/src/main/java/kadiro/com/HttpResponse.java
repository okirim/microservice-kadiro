package kadiro.com;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class HttpResponse<T> implements Serializable {

    private int status=HttpStatus.OK.value();
    private String message=HttpStatus.OK.toString();
    private T data;

    public HttpResponse(T data) {
        this.data = data;
    }

    public HttpResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public HttpResponse(String message,int status, T data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
