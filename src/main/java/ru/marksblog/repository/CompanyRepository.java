package ru.marksblog.repository;

import org.springframework.stereotype.Repository;
import ru.marksblog.entity.Company;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CompanyRepository {

    private int id=1;
    private Map<Integer,Company> list=new HashMap<>();

    public void persist(Company obj){
        if(obj != null){
            obj.setId(id);
            list.put(id,obj);
            id++;
        }
    }

    public Map<Integer,Company> findAll() {
        return list;
    }

    public void deleteById(int id){
        list.remove(id);
    }

    public void update(int id,String companyName,String description,String address,int phoneNumber){
        for(Company company:list.values()){
            if(company.getId() == id){
                company.setCompanyName(companyName);
                company.setDescription(description);
                company.setAddress(address);
                company.setPhoneNumber(phoneNumber);
            }
        }
    }
}
