package ru.marksblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.marksblog.entity.Company;
import ru.marksblog.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void persist(Company obj){ companyRepository.persist(obj); }

    public List<Company> findAll(){ return companyRepository.findAll(); }

    public void deleteById(int id){ companyRepository.deleteById(id); }

    public void update(int id,String companyName,String description,String address,int phoneNumber){ companyRepository.update(id,companyName,description,address,phoneNumber); }

}
