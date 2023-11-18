package company.dto;

import company.entity.User;
import company.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private UserDTO projectAssignedManager;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectEndDate;
    private String projectDetails;
    private Status projectStatus;


    private int completeTaskCounts;
    private int unfinishedTaskCounts;

    public ProjectDTO(String projectName, String projectCode, UserDTO projectAssignedManager, LocalDate projectStartDate, LocalDate projectEndDate, String projectDetails, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.projectAssignedManager = projectAssignedManager;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectDetails = projectDetails;
        this.projectStatus = projectStatus;
    }
}
