package company.controller;

import company.dto.TaskDTO;
import company.enums.Status;
import company.service.ProjectService;
import company.service.TaskService;
import company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "task/create";
    }


    @PostMapping("/create")
    public String createTask2(@ModelAttribute("task") TaskDTO task){

        taskService.save(task);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {

        taskService.deleteById(id);

        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model){

        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        return "task/update";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute("task") TaskDTO task){

        taskService.update(task);

        return "redirect:/task/create";
    }


    @GetMapping("/pending-tasks")
    public String pendingTasks(Model model) {

        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));

        return "task/pending-tasks";
    }

    @GetMapping("/pending-task/update/{id}")
    public String taskEditStatus(@PathVariable("id") Long id, Model model) {

        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));

        return "task/status-update";
    }

    @PostMapping("/pending-task/update/{id}")
    public String taskUpdateStatus(@PathVariable("id") Long id, @ModelAttribute("task") TaskDTO task) {

        taskService.updateStatus(id,task);

        return "redirect:/task/pending-tasks";
    }


    @GetMapping("/archive")
    public String archiveTask(Model model){

        model.addAttribute("tasks", taskService.findAllTasksByStatus(Status.COMPLETE));

        return "task/archive";
    }
}
