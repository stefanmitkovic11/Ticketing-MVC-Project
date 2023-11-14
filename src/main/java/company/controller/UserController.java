package company.controller;

import company.bootstrap.DataGenerator;
import company.dto.RoleDTO;
import company.dto.UserDTO;
import company.service.RoleService;
import company.service.UserService;
import company.service.impl.RoleServiceImpl;
import company.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());


        return "user/create";
    }


    @PostMapping("/create")
    public String createUser2(@ModelAttribute(value = "user") UserDTO user){

        System.out.println(user);

        return "user/create";
    }



}
