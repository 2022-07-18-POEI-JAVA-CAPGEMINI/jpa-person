package com.poe.poe2220718.poe20220718.jpademo;

import java.util.List;

public class Demo {
   
    
    public static void main(String[] args) {
        System.out.println("DEMO");
        
        Person alain = new Person("Alain", "Delon");
        PersonDAO.enregistrer(alain);
        
        Person marie = new Person("Marie", "Dupont");
        marie.setCity("Paris");
        marie.setAge(33);
        
        Company google =  new Company("Google", "USA", "Seatle");
        CompanyDAO.create(google);       
        marie.setCompany(google);
        PersonDAO.enregistrer(marie);
        Person marie2 = PersonDAO.chercherParId(2L);
        System.out.println(marie2);
        System.out.println(marie2.getCompany());
        

           
//        PersonDAO.enregistrer(marie);
//        Company google =  new Company("Google", "USA", "Seatle");
//        google.getPersons().add(marie);
//        CompanyDAO.create(google);  

        
        System.out.println(marie.getCompany());
        System.out.println(google.getPersons().size());
        
//        Person said = new Person("Said", "Dupont");
//        PersonDAO.enregistrer(said);  

//            try {
//                Person said = PersonDAO.chercherParId(2L);
//                System.out.println("Données récupérées de la BD: "+said);
//                System.out.println("Nom famille: "+ said.getLastName());
//            }
//            catch(Exception e){
//                System.out.println("Identifiant non reconnu");
//            }


//        System.out.println("ID personne 2 : "+marie.getId());
        
       // PersonDAO.supprimerUnePersonne(marie);
       // PersonDAO.supprimerParId(2L);
//       Person newData = new Person();
//       newData.setLastName("Martin");
//       newData.setCity("Marseille");
//       PersonDAO.modifierPersonne(2L, newData);
//       
//
//        List<Person> personnes = PersonDAO.chercherToutesLesPersonnes();
//        for(Person p : personnes){
//            System.out.println("Personne de ma DB : "+p);
//        }
    }
}
