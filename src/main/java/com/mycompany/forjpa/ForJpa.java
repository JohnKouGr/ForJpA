package com.mycompany.forjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Course;



public class ForJpa {

    public static void main(String[] args) {
        
  

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("name_ForJpa");

        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, 1);

//        r.setCoursename("abhgfba");
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        

        
    }

}
