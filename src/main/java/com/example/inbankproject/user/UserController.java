package com.example.inbankproject.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    UserStorage userStorage = new UserStorage();

    //display all users to add loan for them
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userStorage.getUsers());
        return "users.html";
    }
}
