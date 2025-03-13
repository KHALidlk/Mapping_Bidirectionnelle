package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoM {
    public DaoM() {
    }

    EntityManagerFactory emf= Persistence.createEntityManagerFactory("myjpa");
    public void AjouterCours(Cours modele)
    {
        EntityManager em=emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(modele);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
