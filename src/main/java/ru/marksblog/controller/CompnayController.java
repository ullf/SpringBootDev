package ru.marksblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.marksblog.entity.Company;
import ru.marksblog.service.CompanyService;

import java.util.List;

@Controller
public class CompnayController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company")
    public String company(Model model,Company company){
        model.addAttribute("companies",company);
        model.addAttribute("company",companyService.findAll());
        return "company";
    }

    @PostMapping("/companyadd")
    public String addCompany(Company company){
        companyService.persist(company);
        return "redirect:/company";
    }

    @PostMapping("/companydelete")
    public String deleteCompany(Company company){
        companyService.deleteById(company.getId());
        return "redirect:/company";
    }

    @PostMapping("/companyupdate")
    public String updateCompany(Company company){
        companyService.update(company.getId(),company.getCompanyName(),company.getDescription(),company.getAddress(),company.getPhoneNumber());
        return "redirect:/company";
    }
}
