package ru.marksblog.repository;

import org.springframework.stereotype.Repository;
import ru.marksblog.entity.Company;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {

    private List<Company> list=new ArrayList<>();

    public void persist(Company obj){
        if(obj != null){
            list.add(obj);
        }
    }

    public List<Company> findAll() {
        return list;
    }

    public void deleteById(int id){
        for(Company company:list){
            if(company.getId() == id){
                list.remove(company);
            }
        }
    }

    public void update(int id,String companyName,String description,String address,int phoneNumber){
        for(Company company:list){
            if(company.getId() == id){
                company.setCompanyName(companyName);
                company.setDescription(description);
                company.setAddress(address);
                company.setPhoneNumber(phoneNumber);
            }
        }
    }
}
