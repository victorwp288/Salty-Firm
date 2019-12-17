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
import org.springframework.web.bind.annotation.ModelAttribute;
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


    @GetMapping("/firms/{userId}/{firmId}")
    public String firms(@PathVariable int userId, @PathVariable int firmId, Model model) {
        List<Department> department = departmentService.getDepartments(firmId);
        User user = new User();
        if (userId != 0) {
            user = userService.findUserById(userId);
        }
        model.addAttribute("user",user);
        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firms", firm);
        model.addAttribute("departments", department);
        return "firm";
    }


    @GetMapping("/department/{userId}/{firmId}/{departmentId}")
    public String departments(@PathVariable int userId, @PathVariable int departmentId, @PathVariable int firmId, Model model) {
        Department department = departmentService.findDepartmentById(departmentId);
        Firm firms = firmService.findFirmById(firmId);
        List<Review> review = departmentService.getAllReviews(departmentId);
        Review departmentScore = departmentService.getRealDepartmentScores(departmentId);
        User user = new User();
        if (userId != 0) {
            user = userService.findUserById(userId);
        }
        model.addAttribute("user",user);
        model.addAttribute("firms", firms);
        model.addAttribute("departments", department);
        model.addAttribute("reviews", review);
        model.addAttribute("department", departmentScore);
        return "department";
    }

    @GetMapping("/firmList/editFirm/{firmId}/{userId}")
    public String editFirm(@PathVariable int userId, @PathVariable int firmId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firm", firm);
        return "editFirm";
    }

    @PostMapping("/firmList/editFirm/{firmId}/{userId}")
    public String doneEditingFirm(@PathVariable int userId, @ModelAttribute Firm firm, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        firmService.editFirm(firm);
        return "redirect:/firmList/{userId}";
    }

    @GetMapping("/firmList/deleteFirm/{firmId}/{userId}")
    public String deleteForm(@PathVariable int userId, @PathVariable int firmId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firm", firm);
        return "deleteFirm";
    }

    @PostMapping("/firmList/deleteFirm/{firmId}/{userId}")
    public String postDeleteForm(Model model, @PathVariable int userId, @PathVariable int firmId) {
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
        User user = userService.findUserById(userId);
        if (userId != 0) {
            user = userService.findUserById(userId);
        }
        model.addAttribute("user", user);
        model.addAttribute("firmlist", firm);
        return "firmList";
    }

    @GetMapping("firmList/departmentList/{firmId}/{userId}")
    public String departmentList(Model model, @PathVariable int userId, @PathVariable int firmId) {
        List<Department> departments = departmentService.getDepartments(firmId);
        User user = userService.findUserById(userId);
        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firm", firm);
        model.addAttribute("user", user);
        model.addAttribute("departmentList", departments);
        return "departmentList";
    }

    @GetMapping("/firmList/departmentList/{firmId}/editDepartment/{departmentId}/{userId}")
    public String editDepartment(Model model, @PathVariable int firmId, @PathVariable int departmentId, @PathVariable int userId) {
        Department department = departmentService.findDepartmentById(departmentId);
        model.addAttribute("department", department);
        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firm", firm);
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "editDepartment";
    }

    @PostMapping("/firmList/departmentList/{firmId}/editDepartment/{departmentId}/{userId}")
    public String doneEditingDepartment(Model model, @PathVariable int firmId, @ModelAttribute Department department, @PathVariable int userId) {
        departmentService.editDepartment(department);
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "redirect:/firmList/departmentList/{firmId}/{userId}";
    }

    @GetMapping("/firmList/departmentList/{firmId}/deleteDepartment/{departmentId}/{userId}")
    public String deleteDepartment(@PathVariable int userId, @PathVariable int firmId, @PathVariable int departmentId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firm", firm);
        Department department = departmentService.findDepartmentById(departmentId);
        model.addAttribute("department", department);
        return "deleteDepartment";
    }

    @PostMapping("/firmList/departmentList/{firmId}/deleteDepartment/{departmentId}/{userId}")
    public String postDeleteDepartment(Model model, @PathVariable int userId, @PathVariable int firmId, @PathVariable int departmentId) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        Firm firm = firmService.findFirmById(firmId);
        model.addAttribute("firm", firm);
        Department department = departmentService.findDepartmentById(departmentId);
        model.addAttribute("department", department);
        departmentService.deleteDepartment(departmentId);
        return "redirect:/firmList/departmentList/{firmId}/{userId}";
    }
}