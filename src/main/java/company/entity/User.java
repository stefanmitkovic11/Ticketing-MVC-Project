package company.entity;

import company.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
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
}
