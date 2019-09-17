package com.mycompany.forjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Course;

public class ForJpa {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ForJpa");

        EntityManager em = emf.createEntityManager();

        Course r = em.find(Course.class, 1);

//        r.setCoursename("abhgfba");
        
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
    }

}
