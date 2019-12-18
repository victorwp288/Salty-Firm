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

/**
 * @author Martin /
 */

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
        Firm firm = new Firm();
        model.addAttribute("firm", firm);
        return "home";
    }

    @GetMapping("/{currentUserId}")
    public String index2(@PathVariable int currentUserId, Model model){
        if (currentUserId == 0) {
            return "redirect:/";
        }
        User user = userService.findUserById(currentUserId);
        model.addAttribute(user);
        Firm firm = new Firm();
        model.addAttribute("firm", firm);
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

    @PostMapping("/search/{userId}")
    public String searchIndex(@PathVariable int userId, @ModelAttribute Firm firm, Model model) {
        model.addAttribute("user",userService.findUserById(userId));
        return "redirect:/search/{userId}/"+firm.getFirmName();
    }

    @GetMapping("/search/{userId}/{searchWord}")
    public String searchResult(Model model, @PathVariable int userId, @PathVariable String searchWord) {
        List<Firm> searchResult = firmService.searchFirms(searchWord);
        model.addAttribute("list", searchResult);
        User user = new User();
        if (userId != 0) {
            user = userService.findUserById(userId);
        }
        model.addAttribute("user",user);
        Firm firm = new Firm();
        model.addAttribute("firm", firm);
        String word = "searchWord";
        model.addAttribute("searchWord", searchWord);
        return "search";
    }
}
