package ru.marksblog.entity;

import org.springframework.stereotype.Component;

@Component
public class Company{

    private int id;
    private String companyName;
    private String description;
    private int phoneNumber;
    private String address;

    public Company(){

    }

    public Company(int id,String companyName,String description,int phoneNumber,String address){
        this.id=id;
        this.companyName=companyName;
        this.description=description;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
