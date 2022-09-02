package com.poe.poe2220718.poe20220718.jpademo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;

    public Person() {
    }
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", city=" + city + '}';
    }
    
    public void setNotNullData(Person newPersonData){
        
      if(newPersonData.getAge() != null) {
          this.setAge(newPersonData.getAge());
      }
      if(newPersonData.getCity() != null) {
          this.setCity(newPersonData.getCity());
      }
      if(newPersonData.getFirstName()!= null) {
          this.setFirstName(newPersonData.getFirstName());
      }
      if(newPersonData.getLastName()!= null) {
          this.setLastName(newPersonData.getLastName());
      }
    }
}
