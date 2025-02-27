package com.codegym.controller;

import com.codegym.model.DTO.ProvinceDTO;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dto")
public class DTOController {
    @Autowired
    private IProvinceService iProvinceService;

    @ModelAttribute("message")
    public String getMessage() {
        return "Hello World from DTOController";
    }

    @RequestMapping("")
    public String showDTO(Model model) {
        Iterable<ProvinceDTO> result = iProvinceService.getProvince();
        model.addAttribute("provinces", result);
        return "/index";
    }
}
