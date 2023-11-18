package company.service;

import company.dto.ProjectDTO;
import company.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO,String> {
    void complete(ProjectDTO object);

    List<ProjectDTO> findAllNonCompletedProjects();

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);

}
