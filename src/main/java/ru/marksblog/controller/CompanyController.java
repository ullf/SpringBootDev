package ru.marksblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.marksblog.entity.Company;
import ru.marksblog.service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company")
    public String company(Model model, Company company) {
        model.addAttribute("companies", company);
        model.addAttribute("company", companyService.findAll().values());
        return "company";
    }

    @GetMapping("/company-add")
    public String companyAdd(Model model, Company company) {
        model.addAttribute("companies", company);
        return "company-add";
    }

    @PostMapping("/companyadd")
    public String addCompany(Company company) {
        companyService.persist(company);
        return "redirect:/company";
    }

    @GetMapping("/companydelete")
    public String deleteCompany(@RequestParam("id") int id) {
        companyService.deleteById(id);
        return "redirect:/company";
    }

    @PostMapping("/companyupdate")
    public String updateCompany(Company company) {
        companyService.update(company.getId(), company.getCompanyName(), company.getDescription(), company.getAddress(), company.getPhoneNumber());
        return "redirect:/company";
    }
}
