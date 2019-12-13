package com.saltyfirm.saltyfirm.Controllers;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.Firm;
import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DepartmentRepository;
import com.saltyfirm.saltyfirm.Repositories.FirmRepository;
import com.saltyfirm.saltyfirm.Repositories.UserRepository;
import com.saltyfirm.saltyfirm.Services.DepartmentService;
import com.saltyfirm.saltyfirm.Services.FirmService;
import com.saltyfirm.saltyfirm.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FirmController {

    @Autowired
    FirmService firmService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;


    @GetMapping("/firms/{firmId}")
    public String firms(@PathVariable int firmId, Model model) {

        List<Department> department = departmentService.getDepartments(firmId);


        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firms", firm);
        model.addAttribute("departments", department);
        return "firm";
    }

    /*
    @PostMapping("/firm")
    public String postFrim(@ModelAttribute Firm firm, @ModelAttribute Department department, Model model) {

        return "redirect:/department/"+firm.getFirmId() + "/" + department.getDepartmentId();
    }

     */

    @GetMapping("/department/{firmId}/{departmentId}")
    public String departments(@PathVariable int departmentId, @PathVariable int firmId, Model model) {

        Department department = departmentService.findDepartmentById(departmentId);
        Firm firms = firmService.findFirmById(firmId);
        List<Review> review = departmentService.getAllReviews(departmentId);
        Review departmentScore = departmentService.getRealDepartmentScores(departmentId);

        model.addAttribute("firms", firms);
        model.addAttribute("departments", department);
        model.addAttribute("reviews", review);
        model.addAttribute("department", departmentScore);
        return "department";
    }

    @GetMapping("/firms/{firmId}/{userId}")
    public String deleteForm(@PathVariable int userId, @PathVariable int firmId, Model model) {

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firm", firm);

        return "deleteFirm";
    }

    @PostMapping("/firms/{firmId}/{userId}")
    public String delete(Model model, @PathVariable int userId, @PathVariable int firmId) {

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firm", firm);

        firmService.deleteFirm(firmId);

        return "redirect:/";
    }

    @GetMapping("/firmList/{userId}")
    public String firmList(Model model, @PathVariable int userId) {
        List<Firm> firm = firmService.getAllFirms();

        model.addAttribute("firmlist", firm);
        return "firmList";

    }

    @GetMapping("/departmentList/{userId}")
    public String departmentList(Model model, @PathVariable int userId, @PathVariable int firmId) {
        List<Department> departments = departmentService.getDepartments(firmId);

        model.addAttribute("departmentList", departments);
        return "departmentList";

    }
}