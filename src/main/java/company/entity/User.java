package company.entity;

import company.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String password;
    private boolean enabled;
    private Gender gender;
    private Role role;


    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String firstName, String lastName, String userName, String phoneNumber, String password, boolean enabled, Gender gender, Role role) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.enabled = enabled;
        this.gender = gender;
        this.role = role;
    }
}
