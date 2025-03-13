package com.example.demo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoS {
    public DaoS() {
    }

    EntityManagerFactory emf=Persistence.createEntityManagerFactory("myjpa");
    public void AjouterStudent(Student studentEntity)
    {
        EntityManager em=emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(studentEntity);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }


}
