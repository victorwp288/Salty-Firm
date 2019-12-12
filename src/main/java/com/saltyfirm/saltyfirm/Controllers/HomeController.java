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
        String searchWord = "";
        model.addAttribute("searchWord", searchWord);
        return "home";
    }

    @GetMapping("/{currentUserId}")
    public String index2(@PathVariable int currentUserId, Model model){
        User user = userService.findUserById(currentUserId);
        model.addAttribute(user);
        String searchWord = "";
        model.addAttribute(searchWord);
        return "home";
    }

    @PostMapping("/")
    public String postIndexLogin(@ModelAttribute User loginUser, Model model) {
        User user = userService.checkLogin(loginUser.getUsername(), loginUser.getPassword());
        if (user != null) {
            model.addAttribute(user);
            return "redirect:/"+user.getUserId();
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/search")
    public String searchIndex(@ModelAttribute String searchWord, Model model) {

        return "redirect:/search/"+searchWord;
    }

    @GetMapping("/search/{searchWord}")
    public String searchResult(Model model, @PathVariable String searchWord) {
        List<Firm> searchResult = firmService.searchFirms(searchWord);
        model.addAttribute("list", searchResult);
        return "search";
    }
}
