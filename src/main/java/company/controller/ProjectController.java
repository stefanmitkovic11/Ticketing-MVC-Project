package company.controller;

import company.dto.ProjectDTO;
import company.dto.UserDTO;
import company.service.ProjectService;
import company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;


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

        List<UserDTO> listOfManagers = userService.findAll().stream().filter(each -> each.getRole().getDescription().equals("Manager")).collect(Collectors.toList());

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("managers", listOfManagers);
        model.addAttribute("projects", projectService.findAll());

        return "project/create";
    }


    @PostMapping("/create")
    public String createProject2(@ModelAttribute("project") ProjectDTO project) {
        projectService.save(project);


        return "redirect:/project/create";
    }
}
