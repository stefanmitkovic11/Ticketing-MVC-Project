package company.dto;

import company.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private ProjectDTO taskProject;
    private UserDTO taskAssignedEmployee;
    private String taskSubject;
    private String taskDetails;
    private Status taskStatus;
}
