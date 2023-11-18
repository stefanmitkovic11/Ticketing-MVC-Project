package company.dto;

import company.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TaskDTO {
    private Long taskId;
    private ProjectDTO taskProject;
    private UserDTO taskAssignedEmployee;
    private String taskSubject;
    private String taskDetails;
    private Status taskStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate taskAssignedDate;

    public TaskDTO(ProjectDTO taskProject, UserDTO taskAssignedEmployee, String taskSubject, String taskDetails, Status taskStatus, LocalDate taskAssignedDate) {
        this.taskProject = taskProject;
        this.taskAssignedEmployee = taskAssignedEmployee;
        this.taskSubject = taskSubject;
        this.taskDetails = taskDetails;
        this.taskStatus = taskStatus;
        this.taskAssignedDate = taskAssignedDate;
        this.taskId = UUID.randomUUID().getMostSignificantBits();
    }
}
