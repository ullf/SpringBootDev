package ru.marksblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.marksblog.entity.Company;
import ru.marksblog.integration.SimpleGateway;
import ru.marksblog.service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SimpleGateway simpleGateway;

    @GetMapping("/company")
    public String company(Model model, Company company) {
        model.addAttribute("companies", company);
        model.addAttribute("company", companyService.findAll());
        return "company";
    }

    @GetMapping("/gate")
    public Company gate(){
        Company company=new Company();
        company.setId(235);
        company.setCompanyName("Yandex");
        simpleGateway.doit(MessageBuilder.withPayload(company)
                .build());
        return new Company();
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
        companyService.persist(company);
        return "redirect:/company";
    }
}
