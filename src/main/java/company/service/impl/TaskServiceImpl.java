package company.service.impl;

import company.dto.TaskDTO;
import company.dto.UserDTO;
import company.enums.Status;
import company.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {

        if (object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }

        if (object.getTaskAssignedDate() == null) {
            object.setTaskAssignedDate(LocalDate.now());
        }

        if (object.getTaskId() == null) {
            object.setTaskId(UUID.randomUUID().getLeastSignificantBits());
        }

        return super.save(object.getTaskId(), object);

    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {

        TaskDTO foundTask = super.findById(object.getTaskId());

        if (foundTask.getTaskStatus() == null) {
            object.setTaskStatus(foundTask.getTaskStatus());
        }

        object.setTaskAssignedDate(foundTask.getTaskAssignedDate());

        super.update(object.getTaskId(), object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return findAll().stream().filter(task -> task.getTaskProject().getProjectAssignedManager().equals(manager)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatus(Status status) {
        return findAll().stream().filter(task -> task.getTaskStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatusIsNot(Status status) {
        return findAll().stream().filter(task -> !task.getTaskStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(Long id, TaskDTO task) {
        findById(id).setTaskStatus(task.getTaskStatus());
        update(findById(id));
    }

}
