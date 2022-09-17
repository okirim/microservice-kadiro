package kadiro.com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class HttpResponseWithPagination<T> implements Serializable {
    private int status=HttpStatus.OK.value();
    private String message=HttpStatus.OK.toString();
    private T data;
    private int currentPage;
    private Long totalElements;
    private int totalPages;
}
