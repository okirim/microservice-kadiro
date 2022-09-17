package kadiro.com.permission;

import lombok.Data;

import java.io.Serializable;


@Data
public class PermissionVM implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
}
