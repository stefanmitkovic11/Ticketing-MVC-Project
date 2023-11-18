package company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ProjectStatusController {


    @GetMapping("/project-status")
    public String projectStatus() {


        return "manager/project-status";
    }
}
