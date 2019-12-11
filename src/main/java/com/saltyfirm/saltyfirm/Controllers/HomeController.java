package com.saltyfirm.saltyfirm.Controllers;

import com.saltyfirm.saltyfirm.Models.Firm;
import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Services.FirmService;
import com.saltyfirm.saltyfirm.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;
    @Autowired
    FirmService firmService;

    @GetMapping("/")
    public String index1(Model model){
        User user = new User();
        model.addAttribute(user);
        String word = "";
        model.addAttribute(word);
        return "home";
    }

    @GetMapping("/{currentUserId}")
    public String index2(@PathVariable int currentUserId, Model model){
        User currentUser = userService.findUserById(currentUserId);
        model.addAttribute(currentUser);
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

    @PostMapping("/{searchWord}")
    public String searchIndex(@PathVariable String searchWord, Model model) {
        List<Firm> searchResult = firmService.searchFirms(searchWord);
        model.addAttribute(searchResult);
        return "search";
    }


}
