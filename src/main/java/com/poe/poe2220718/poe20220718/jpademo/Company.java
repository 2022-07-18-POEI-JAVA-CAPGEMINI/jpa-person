package com.poe.poe2220718.poe20220718.jpademo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="companies")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String country;
    private String city;

    public Company() {
    }
    public Company(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", country=" + country + ", city=" + city + '}';
    }
    
    
    public void setNotNullData(Company newCompanyData){
        
      if(newCompanyData.getName() != null) {
          this.setName(newCompanyData.getName());
      }
      if(newCompanyData.getCity() != null) {
          this.setCity(newCompanyData.getCity());
      }
      if(newCompanyData.getCountry()!= null) {
          this.setCountry(newCompanyData.getCountry());
      }

    }
    
}
