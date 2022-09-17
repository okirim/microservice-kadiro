package kadiro.com.user;

import lombok.Data;

@Data
public class UserReq{
    private String username;
    private String password;
    private String PasswordConfirm;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String zipCode;
}
