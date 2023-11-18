package company.controller;

import company.dto.TaskDTO;
import company.service.ProjectService;
import company.service.TaskService;
import company.service.UserService;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    ProjectService projectService;
    UserService userService;
    TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model){

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects",  projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        System.out.println(taskService.findAll());

        return "task/create";
    }


    @PostMapping("/create")
    public String createTask2(@ModelAttribute("task") TaskDTO task){

        taskService.save(task);

        return "redirect:/task/create";
    }
}
