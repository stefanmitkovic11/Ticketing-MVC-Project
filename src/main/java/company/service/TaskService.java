package company.service;

import company.dto.TaskDTO;
import company.dto.UserDTO;
import company.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO,Long> {
    List<TaskDTO> findTasksByManager(UserDTO manager);

    List<TaskDTO> findAllTasksByStatus(Status status);

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    void updateStatus(Long id, TaskDTO task);
}
