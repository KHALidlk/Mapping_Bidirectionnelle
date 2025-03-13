package com.example.demo;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class DaoA {
    public DaoA() {
    }

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
    public void AjouterAdress(Adresse adresse)
    {
        EntityManager em=emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(adresse);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

}
