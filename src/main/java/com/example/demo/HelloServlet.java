package com.example.demo;

import java.util.Arrays;

public class HelloServlet  {
    public static void main(String[] args) {
        // Créer les objets DAO
        DaoA daoA = new DaoA();
        DaoS daoS = new DaoS();
        DaoM daoC = new DaoM();
        DaoF daoF = new DaoF(); // DAO pour gérer les filières

        // Créer une adresse
        Adresse adresse = new Adresse();
        adresse.setAdresse_id(1);
        adresse.setCity("Paris");
        adresse.setState("Ile-de-France");
        adresse.setStreet("Champs-Élysées");
        daoA.AjouterAdress(adresse);

        // Créer des cours
        Cours cours1 = new Cours();
        cours1.setCours_id(1);
        cours1.setNom("Mathematics");

        Cours cours2 = new Cours();
        cours2.setCours_id(2);
        cours2.setNom("Science");

        daoC.AjouterCours(cours1);
        daoC.AjouterCours(cours2);

        // Créer des filières
        Filier filier1 = new Filier();
        filier1.setNom("Informatique");

        Filier filier2 = new Filier();
        filier2.setNom("Gestion");

        daoF.Ajouter(filier1);
        daoF.Ajouter(filier2);

        // Créer un étudiant et lier des filières
        Student student1 = new Student();
        student1.setStudent_id(1);
        student1.setName("John Doe");
        student1.setEmail("john.doe@example.com");
        student1.setAdresse(adresse);
        student1.setCours(Arrays.asList(cours1));
        student1.setFiliers(Arrays.asList(filier1, filier2)); // Lier les filières
        daoS.AjouterStudent(student1);

        Student student2 = new Student();
        student2.setStudent_id(2);
        student2.setName("Jane Smith");
        student2.setEmail("jane.smith@example.com");
        student2.setAdresse(adresse);
        student2.setCours(Arrays.asList(cours2));
        student2.setFiliers(Arrays.asList(filier1)); // Lier à une seule filière
        daoS.AjouterStudent(student2);

        // Afficher les informations pour vérifier
        System.out.println("Student 1 Name: " + student1.getName());
        System.out.println("Student 1 Email: " + student1.getEmail());
        for (Filier f : student1.getFiliers()) {
            System.out.println("Filiere: " + f.getNom());
        }

        System.out.println("Student 2 Name: " + student2.getName());
        System.out.println("Student 2 Email: " + student2.getEmail());
        for (Filier f : student2.getFiliers()) {
            System.out.println("Filiere: " + f.getNom());
        }
    }
}