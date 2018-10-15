package ru.marksblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.marksblog.entity.Company;
import ru.marksblog.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void persist(Company obj){ companyRepository.save(obj); }

    public Iterable<Company> findAll(){ return companyRepository.findAll(); }

    public void deleteById(int id){ companyRepository.deleteById(id); }
}
