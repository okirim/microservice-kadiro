package kadiro.com.user;

import kadiro.com.role.Role;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private Date createdAt;
    private Date updatedAt;
    private Role role;
}
