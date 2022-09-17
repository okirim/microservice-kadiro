package kadiro.com.permission;

import lombok.Data;

@Data
public class Permission {
    private Long id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
}
