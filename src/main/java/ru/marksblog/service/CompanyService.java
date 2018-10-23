package ru.marksblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.marksblog.entity.Company;
import ru.marksblog.repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class CompanyService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private CompanyRepository companyRepository;

    public void persist(Company obj){ companyRepository.save(obj); }

    public Iterable<Company> findAll(){ return companyRepository.findAll(); }

    public void deleteById(int id){ companyRepository.deleteById(id); }

    public Company findByName(String name){
        return companyRepository.findByName(name);
    }
}
