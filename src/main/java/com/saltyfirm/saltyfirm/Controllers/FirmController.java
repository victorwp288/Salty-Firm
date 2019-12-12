package com.saltyfirm.saltyfirm.Controllers;

import com.saltyfirm.saltyfirm.Models.Firm;
import com.saltyfirm.saltyfirm.Repositories.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FirmController {

    @Autowired
    FirmRepository firmRepository;

    @GetMapping("/firms/{firmId}")
    public String firms(@PathVariable int firmId, Model model){

        Firm firm = firmRepository.findFirmById(firmId);
        model.addAttribute("firms", firm);
        return "firm";
    }

}
