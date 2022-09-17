package kadiro.com.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
@Data
@NoArgsConstructor
public class ErrorDetails {
    private int status=HttpStatus.INTERNAL_SERVER_ERROR.value();
    private String message=HttpStatus.INTERNAL_SERVER_ERROR.toString();
    private String path;
    private Object error; //String or List<String>
    private String timestamp=String.valueOf(System.currentTimeMillis());
}
