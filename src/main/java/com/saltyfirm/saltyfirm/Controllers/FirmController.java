package com.saltyfirm.saltyfirm.Controllers;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.Firm;
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

}
