package company.controller;

import company.dto.ProjectDTO;
import company.service.ProjectService;
import company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model) {

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("managers", userService.findManagers());
        model.addAttribute("projects", projectService.findAll());

        return "project/create";
    }


    @PostMapping("/create")
    public String createProject2(@ModelAttribute("project") ProjectDTO project) {
        projectService.save(project);

        return "redirect:/project/create";
    }


    @GetMapping("/update/{code}")
    public String editProject(@PathVariable("code") String code, Model model) {
        model.addAttribute("project", projectService.findById(code));
        model.addAttribute("managers", userService.findManagers());
        model.addAttribute("projects", projectService.findAll());

        return "project/update";
    }


    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO project) {
        projectService.update(project);

        return "redirect:/project/create";
    }


    @GetMapping("/delete/{code}")
    public String deleteProject(@PathVariable("code") String code) {
        projectService.deleteById(code);

        return "redirect:/project/create";
    }


    @GetMapping("/complete/{code}")
    public String completeProject(@PathVariable("code") String code) {
        projectService.complete(projectService.findById(code));

        return "redirect:/project/create";
    }


    @GetMapping("/project-status")
    public String projectStatus(Model model) {

        model.addAttribute("projects",projectService.findAll());

        return "manager/project-status";
    }


    @GetMapping("/project-status/complete/{code}")
    public String completeProject2(@PathVariable("code") String code) {
        projectService.complete(projectService.findById(code));

        return "redirect:/project/project-status";
    }

}
