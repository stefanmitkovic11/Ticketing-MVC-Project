package company.bootstrap;

import company.dto.RoleDTO;
import company.dto.UserDTO;
import company.enums.Gender;
import company.service.RoleService;
import company.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }



    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");


        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);


        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@cydeo.com", "7459684532", "Abc2", true, Gender.MALE, managerRole);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com", "7459684532", "Abc2", true, Gender.MALE, adminRole);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cydeo.com", "8567412358", "123", true, Gender.FEMALE, managerRole);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com", "7777775566", "1245", true, Gender.MALE, employeeRole);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cydeo.com", "3256987412", "1235", true, Gender.MALE, managerRole);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cydeo.com", "5306987412", "12415", true, Gender.FEMALE, employeeRole);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cydeo.com", "9996987412", "1554", true, Gender.FEMALE, employeeRole);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cydeo.com", "8881239846", "12415", true, Gender.MALE, employeeRole);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);





    }
}
