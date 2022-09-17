package kadiro.com.user;

import kadiro.com.role.RoleVM;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVM implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private RoleVM role;
}
