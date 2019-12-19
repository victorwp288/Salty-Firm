package com.saltyfirm.saltyfirm.Controllers;

import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.HashRepositoryImpl;
import com.saltyfirm.saltyfirm.Services.API.TwilloSms;
import com.saltyfirm.saltyfirm.Services.ReviewService;
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
 * @author Martin / Victor.
 */

@Controller
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    HashRepositoryImpl hashRepository;

    @Autowired
    ReviewService reviewService;
    @Autowired
    TwilloSms twilloSms;

    @GetMapping("/createUser")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {

        if (hashRepository.usernameExists(user)) {
            return "redirect:/createUser";
        } else {
            userService.createUser(user);
            twilloSms.sms(user.getPhoneNumber());
            return "redirect:/";
        }
    }

    @GetMapping("/user/{userId}")
    public String userProfile(Model model, @PathVariable int userId) {
        User user = userService.findUserById(userId);
        model.addAttribute(user);
        List<Review> review = reviewService.fetchUserReview(userId);
        model.addAttribute("reviews", review);
        return "user";
    }

    @GetMapping("/user/editUser/{userId}")
    public String editUser(Model model, @PathVariable int userId) {
        log.info("Starting editUser - finding user..");
        User user = userService.findUserById(userId);
        model.addAttribute("user",user);
        log.info("editUser User found - returning 'editUser html'");
        return "editUser";
    }

    @PostMapping("/user/editUser/{userId}")
    public String updateUser(@ModelAttribute User current, @PathVariable int userId, Model model) {
        log.info("Starting update User - finding user..");
        User user = userService.findUserById(userId);
        log.info("1");
        model.addAttribute("user", userService.findUserById(userId));
        log.info("2");
        userService.editUser(current);
        log.info("update User done - redirecting til /user/{userId}");
        return "redirect:/user/{userId}";
    }

    @GetMapping("/user/deleteBasicUser/{userId}")
    public String deleteForm(@PathVariable int userId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "deleteBasicUser";
    }

    @PostMapping("/user/deleteBasicUser/{userId}")
    public String delete(Model model, @PathVariable int userId){
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        userService.deleteUser(userId);
        return "redirect:/";
    }

    @GetMapping("/userList/{userId}")
    public String userList(Model model, @PathVariable int userId) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        List<User> users = userService.getAllUsers();
        model.addAttribute("userlist", users);
        return "userList";
    }

    @GetMapping("/userList/deleteUser/{userId}/{adminId}")
    public String deleteForm(@PathVariable int userId, @PathVariable int adminId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        User admin = userService.findUserById(adminId);
        model.addAttribute("admin", admin);
        return "deleteUser";
    }

    @PostMapping("/userList/deleteUser/{userId}/{adminId}")
    public String delete(Model model, @PathVariable int userId, @PathVariable int adminId){
        userService.deleteUser(userId);
        User admin = userService.findUserById(adminId);
        model.addAttribute("admin", admin);
        if (admin != null) {
            return "redirect:/userList/{adminId}";
        } else {
            return "redirect:/";
        }

    }

    @GetMapping("/userList/editUser/{userId}")
    public String editAdminForm(@PathVariable int userId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/userList/editUser/{userId}")
    public String updateUser(@ModelAttribute User user){
        userService.editUser(user);
        return "redirect:/user/{userId}";
    }

}
