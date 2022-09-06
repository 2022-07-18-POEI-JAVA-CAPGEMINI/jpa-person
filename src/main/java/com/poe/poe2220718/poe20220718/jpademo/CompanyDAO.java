package com.poe.poe2220718.poe20220718.jpademo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class CompanyDAO {
    
    public static void create(Company companyToCreate) {
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
                
        try {
            System.out.println("company create()");
            tx.begin();
            entityManager.persist(companyToCreate);
            tx.commit();
        }
        catch(Exception e) {
            System.out.println("Exception dans create() : "+e.getMessage());
            tx.rollback();
        }
    }
    
    public static Company findById(Long id){
         EntityManager entityManager = EntityManagerSingleton.getEntityManager();
         
         Company c = entityManager.find(Company.class, id);
         
         return c;
    }
    
    public static List<Company> findAll(){
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        
        Query query = entityManager.createQuery("SELECT c from Company c");
        return query.getResultList();
    }
    
    public static void delete(Company company){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
            EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        entityManager.remove(company);
        tx.commit();
    }
    
    public static void deleteById(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        Query query = entityManager.createQuery("DELETE from Company c where c.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        tx.commit();
    }
    
    public static void update(Long id, Company newData){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        
        Company companyToUpdate = findById(id);
        
        companyToUpdate.setNotNullData(newData);
        
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(companyToUpdate);
        tx.commit();
    }
}
