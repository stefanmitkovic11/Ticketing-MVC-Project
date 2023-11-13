package company.controller;

import company.dto.RoleDTO;
import company.dto.UserDTO;
import company.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles", "");


        return "user/create";
    }


    @PostMapping("/create")
    public String createUser2(@ModelAttribute(value = "user") UserDTO user){

        System.out.println(user);

        return "user/create";
    }



}
