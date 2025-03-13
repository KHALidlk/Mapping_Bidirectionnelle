package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoF {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("myjpa");
    public void Ajouter(Filier filier)
    {
        EntityManager em=emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(filier);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }
}
