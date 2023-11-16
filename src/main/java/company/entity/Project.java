package company.entity;

import company.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Project extends BaseEntity {
    private String projectName;
    private String projectCode;
    private UserDTO projectAssignedManager;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private String projectDetails;


    public Project(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, String projectName, String projectCode, UserDTO projectAssignedManager, LocalDate projectStartDate, LocalDate projectEndDate, String projectDetails) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.projectAssignedManager = projectAssignedManager;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectDetails = projectDetails;
    }

}
