package company.service;

import company.dto.TaskDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO,String> {
    List<TaskDTO> listOfUnfinishedTasks();
    List<TaskDTO> listOfCompletedTasks();
}
