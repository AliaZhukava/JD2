package by.itacademy.controller;

import by.itacademy.entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserListController {

    @ModelAttribute("allUsers")
    public String users() {
        return Client.ClientBuilder.class.getName();
    }

    @GetMapping("/user-list")
    public String showLoginPage() {
        return "user-list";
    }
}
