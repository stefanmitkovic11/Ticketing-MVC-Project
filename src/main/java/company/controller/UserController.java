package company.controller;

import company.entity.User;
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

        model.addAttribute("user",new User());


        return "user/create";
    }


    @PostMapping("/create")
    public String createUser2(@ModelAttribute(value = "user") User user){

        System.out.println(user);

        return "user/create";
    }



}
