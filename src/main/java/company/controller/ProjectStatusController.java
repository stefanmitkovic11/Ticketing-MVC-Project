package company.controller;

import company.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ProjectStatusController {

    ProjectService projectService;

    public ProjectStatusController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/project-status")
    public String projectStatus(Model model) {

        model.addAttribute("projects",projectService.findAll());

        return "manager/project-status";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){

        projectService.complete(projectService.findById(projectCode));

        return "redirect:/manager/project-status";
    }
}
