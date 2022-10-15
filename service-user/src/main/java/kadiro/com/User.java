package kadiro.com;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phone;

    private String address;

    private String city;

    private String country;

    private int zipCode;
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(nullable = true)
    private Timestamp updatedAt;

    private Long roleId;


    @PrePersist
    protected void onCreate() {
         createdAt = new Timestamp(new Date().getTime());
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(new Date().getTime());
    }

}
