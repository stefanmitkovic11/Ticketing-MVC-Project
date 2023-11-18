package company.bootstrap;

import company.dto.ProjectDTO;
import company.dto.RoleDTO;
import company.dto.TaskDTO;
import company.dto.UserDTO;
import company.enums.Gender;
import company.enums.Status;
import company.service.ProjectService;
import company.service.RoleService;
import company.service.TaskService;
import company.service.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;
    TaskService taskService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }


    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");


        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);


        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@abc.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@abc.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@abc.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@abc.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@abc.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@abc.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@abc.com", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@abc.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);


        ProjectDTO project1 = new ProjectDTO("project1", "22342", user2, LocalDate.now(), LocalDate.now(), "Project Details",Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("project2", "22343", user2, LocalDate.now(), LocalDate.now(), "Project Details",Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("project3", "22344", user2, LocalDate.now(), LocalDate.now(), "Project Details",Status.COMPLETE);
        ProjectDTO project4 = new ProjectDTO("project4", "22345", user2, LocalDate.now(), LocalDate.now(), "Project Details", Status.OPEN);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);
        projectService.save(project4);


        TaskDTO task1 = new TaskDTO(project1, user3, "Project Subject1", "Project Details", Status.OPEN, LocalDate.now().minusDays(4));
        TaskDTO task2 = new TaskDTO(project2, user6, "Project Subject2", "Project Details", Status.IN_PROGRESS, LocalDate.now().minusDays(13));
        TaskDTO task3 = new TaskDTO(project3, user7, "Project Subject3", "Project Details", Status.COMPLETE, LocalDate.now().minusDays(12));
        TaskDTO task4 = new TaskDTO(project2, user8, "Project Subject4", "Project Details", Status.OPEN, LocalDate.now().minusDays(15));
        TaskDTO task5 = new TaskDTO(project4, user6, "Project Subject5", "Project Details", Status.IN_PROGRESS, LocalDate.now().minusDays(54));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);
        taskService.save(task5);

    }
}
