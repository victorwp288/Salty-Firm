package com.saltyfirm.saltyfirm.Controllers;

import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DepartmentRepository;
import com.saltyfirm.saltyfirm.Repositories.FirmRepository;
import com.saltyfirm.saltyfirm.Repositories.ReviewRepository;
import com.saltyfirm.saltyfirm.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FirmRepository firmRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/createReview/{userId}")
    public String reviewForm(Model model, @PathVariable int userId){

        log.info("Getting review form in " + this.getClass());
        User user = userRepository.findUserById(userId);

        model.addAttribute("user", user);
        model.addAttribute("review", new Review());
        return "createReview";
    }

    @PostMapping("/createReview/{userId}/{departmentId}/")
    public String createReview(@ModelAttribute Review review, @PathVariable int userId, @PathVariable int departmentId){

        log.info("Submitting review in " + this.getClass());

        reviewRepository.createReview(review, userId, departmentId);

        return "redirect:/{userId}/{departmentId}";
    }

    @GetMapping("/editreview/{userId}/{reviewId}")
    public String editReviewForm(Model model, @PathVariable int userId, @PathVariable int reviewId){
        log.info("Getting edit review form in " + this.getClass());

        User user = userRepository.findUserById(userId);
        model.addAttribute("user", user);
        // Ikke færdig!!
        return "editReview";
    }
}
