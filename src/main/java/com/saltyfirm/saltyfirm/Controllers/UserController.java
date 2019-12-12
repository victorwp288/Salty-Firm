package com.saltyfirm.saltyfirm.Controllers;

import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/createUser")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/user/{userId}")
    public String userProfile(Model model, @PathVariable int userId) {
        User user = userService.findUserById(userId);
        model.addAttribute(user);
        return "user";
    }

    @GetMapping("/editUser/{userId}")
    public String editUser(Model model, @PathVariable int userId) {
        User user = userService.findUserById(userId);
        model.addAttribute(user);
        return "editUser";
    }

    @PostMapping("/editUser/")
    public String updateUser(@ModelAttribute User user, Model model) {
        userService.editUser(user);
        return "redirect:/user/{userId}";
    }
}
