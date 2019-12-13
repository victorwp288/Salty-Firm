package com.saltyfirm.saltyfirm.Controllers;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.Firm;
import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Repositories.DepartmentRepository;
import com.saltyfirm.saltyfirm.Repositories.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FirmController {

    @Autowired
    FirmRepository firmRepository;

    @Autowired
    DepartmentRepository departmentRepository;


    @GetMapping("/firms/{firmId}")
    public String firms(@PathVariable int firmId, Model model){

        List<Department> department = departmentRepository.getDepartments(firmId);


        Firm firm = firmRepository.findFirmById(firmId);
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
    public String departments(@PathVariable int departmentId, @PathVariable int firmId, Model model){

        Department department = departmentRepository.findDepartmentById(departmentId);
        Firm firms = firmRepository.findFirmById(firmId);
        List<Review> review = departmentRepository.getAllReviews(departmentId);
        Review departmentScore = departmentRepository.getRealDepartmentScores(departmentId);

        model.addAttribute("firms", firms);
        model.addAttribute("departments", department);
        model.addAttribute("reviews", review);
        model.addAttribute("department", departmentScore);
        return "department";
    }

    @GetMapping("/firmList/{userId}")
    public String firmList(Model model, @PathVariable int userId){
        List<Firm> firm = firmRepository.getAllFirms();

        model.addAttribute("firmlist", firm);
        return "firmList";
    }

}
