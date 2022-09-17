package kadiro.com.role;

import kadiro.com.permission.PermissionVM;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RoleVM implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
    private List<PermissionVM> permissions;
}
