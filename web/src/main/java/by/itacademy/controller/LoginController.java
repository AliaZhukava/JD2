package by.itacademy.controller;

import by.itacademy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("currentUser")
public class LoginController extends BaseController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(Model model, User user) {
        if ("Test".equals(user.getName())) {
            throw new RuntimeException("User login failed");
        }
        model.addAttribute("currentUser", user);
        return "redirect:/index";
    }

}
