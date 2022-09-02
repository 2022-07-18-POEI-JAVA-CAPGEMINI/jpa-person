package com.poe.poe2220718.poe20220718.jpademo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class PersonDAO {
    
    public static void enregistrer(Person personToCreate) {
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
                
        try {
            System.out.println("create()");
            tx.begin();
            entityManager.persist(personToCreate);//save()
            tx.commit();
        }
        catch(Exception e) {
            System.out.println("Exception dans create() : "+e.getMessage());
            tx.rollback();
        }
    }
    
    public static Person chercherParId(Long id){
         EntityManager entityManager = EntityManagerSingleton.getEntityManager();
         
         Person p = entityManager.find(Person.class, id);
         
         return p;
    }
    
    public static List<Person> chercherToutesLesPersonnes(){
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        
        Query query = entityManager.createQuery("SELECT p from Person p"); // SELECT * FROM persons;
        return query.getResultList();
    }
    
    public static void supprimerUnePersonne(Person personneASupprimer){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        entityManager.remove(personneASupprimer);
        tx.commit();
    }
    
    public static void supprimerParId(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        Query query = entityManager.createQuery("DELETE from Person p where p.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        tx.commit();
    }
    
    public static void modifierPersonne(Long id, Person newData){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        
        Person personToUpdate = chercherParId(id);
        
        personToUpdate.setNotNullData(newData);
        
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(personToUpdate);
        tx.commit();
    }
}
