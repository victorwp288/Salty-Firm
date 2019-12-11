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
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index1(Model model){
        User user = new User();
        model.addAttribute(user);
        String word = "";
        model.addAttribute(word);
        return "home";
    }

    @GetMapping("/{id}")
    public String index2(@PathVariable int id, Model model){
        User user = new User();
        model.addAttribute(user);
        String word = "";
        model.addAttribute(word);
        return "home";
    }

    @PostMapping("/")
    public String postIndexLogin(@ModelAttribute User user, Model model) {
        User loginUser = userService.checkLogin(user.getUsername(), user.getPassword());
        if (loginUser != null) {
            model.addAttribute(loginUser);
            return "redirect:/"+loginUser.getUserId();
        } else {
            return "redirect:/";
        }
    }


}
