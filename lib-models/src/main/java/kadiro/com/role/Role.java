package kadiro.com.role;

import kadiro.com.permission.Permission;
import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Long id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
    private List<Permission> permissions;
}
