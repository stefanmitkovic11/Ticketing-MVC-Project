package company.service.impl;

import company.dto.ProjectDTO;
import company.enums.Status;
import company.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO object) {
        if (object.getProjectStatus() == null) {
            object.setProjectStatus(Status.OPEN);
        }
        super.save(object.getProjectCode(), object);
        return object;
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {

        if(object.getProjectStatus() == null) {
            object.setProjectStatus(findById(object.getProjectCode()).getProjectStatus());
        }

        super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
        super.save(project.getProjectCode(),project);
    }
}
