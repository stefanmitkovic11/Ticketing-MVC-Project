package company.dto;

import company.entity.Role;
import company.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String password;
    private boolean enabled;
    private Gender gender;
    private RoleDTO role;
}
