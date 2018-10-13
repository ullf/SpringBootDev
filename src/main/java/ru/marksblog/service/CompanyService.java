package ru.marksblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.marksblog.Companyw;
import ru.marksblog.entity.Company;
import ru.marksblog.repository.CompanyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void persist(Company obj){ companyRepository.persist(obj); }

    public Map<Integer,Company> findAll(){ return companyRepository.findAll(); }

    public void deleteById(int id){ companyRepository.deleteById(id); }

    public Companyw getById(int id){ return companyRepository.getById(id); }

    public void update(int id,String companyName,String description,String address,int phoneNumber){ companyRepository.update(id,companyName,description,address,phoneNumber); }

}
