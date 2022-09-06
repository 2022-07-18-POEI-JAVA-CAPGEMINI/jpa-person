package com.poe.poe2220718.poe20220718.jpademo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToMany
    private List<Person> persons = new ArrayList<>();
   

    public Project() {
    }
    public Project(String name) {
        this.name = name;
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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + '}';
    }

   

    
    public void setNotNullData(Project newPersonData){
        
//      if(newPersonData.getAge() != null) {
//          this.setAge(newPersonData.getAge());
//      }
//      if(newPersonData.getCity() != null) {
//          this.setCity(newPersonData.getCity());
//      }
//      if(newPersonData.getFirstName()!= null) {
//          this.setFirstName(newPersonData.getFirstName());
//      }
//      if(newPersonData.getLastName()!= null) {
//          this.setLastName(newPersonData.getLastName());
//      }
    }
}
