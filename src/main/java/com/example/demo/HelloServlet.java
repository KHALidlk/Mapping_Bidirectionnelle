package com.example.demo;

import java.util.Arrays;

public class HelloServlet {
    public static void main(String[] args) {
        // DAOs for various entities
        DaoA daoA = new DaoA();
        DaoS daoS = new DaoS();
        DaoM daoM = new DaoM(); // Assuming DaoC exists for Cours
        DaoF daoF = new DaoF(); // Assuming DaoF exists for Filier

        // --- Create Adresse entities ---
        Adresse adresse1 = new Adresse();
        adresse1.setCity("Paris");
        adresse1.setState("Ile-de-France");
        adresse1.setStreet("Champs-Élysées");

        Adresse adresse2 = new Adresse();
        adresse2.setCity("Lyon");
        adresse2.setState("Auvergne-Rhône-Alpes");
        adresse2.setStreet("Rue de la République");

        // --- Create Cours entities ---
        Cours cours1 = new Cours();
        cours1.setCours_id(1);
        cours1.setNom("Mathematics");

        Cours cours2 = new Cours();
        cours2.setCours_id(2);
        cours2.setNom("Science");

        daoM.AjouterCours(cours1);
        daoM.AjouterCours(cours2);

        // --- Create Filier entities ---
        Filier filier1 = new Filier();
        filier1.setNom("Informatique");

        Filier filier2 = new Filier();
        filier2.setNom("Gestion");

        daoF.Ajouter(filier1);
        daoF.Ajouter(filier2);

        // --- Create Student entities ---
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setEmail("john.doe@example.com");
        student1.setAdresse(adresse1); // Link address
        student1.setCours(Arrays.asList(cours1));
        student1.setFiliers(Arrays.asList(filier1, filier2)); // Link filiers
        adresse1.setStudent(student1); // Synchronize inverse relationship

        Student student2 = new Student();
        student2.setName("Jane Smith");
        student2.setEmail("jane.smith@example.com");
        student2.setAdresse(adresse2); // Link address
        student2.setCours(Arrays.asList(cours2));
        student2.setFiliers(Arrays.asList(filier1)); // Link filiers
        adresse2.setStudent(student2); // Synchronize inverse relationship

        // --- Persist entities ---
        daoS.AjouterStudent(student1); // Student persists with address, courses, and filiers
        daoS.AjouterStudent(student2);

        // --- Test and Output ---
        System.out.println("Testing Relationships:");

        // Retrieve and print Student 1
        System.out.println("Student 1 Name: " + student1.getName());
        System.out.println("Student 1 Email: " + student1.getEmail());
        System.out.println("Student 1 Adresse: " + student1.getAdresse().getCity());
        for (Filier f : student1.getFiliers()) {
            System.out.println("Student 1 Filiere: " + f.getNom());
        }

        // Retrieve and print Student 2
        System.out.println("Student 2 Name: " + student2.getName());
        System.out.println("Student 2 Email: " + student2.getEmail());
        System.out.println("Student 2 Adresse: " + student2.getAdresse().getCity());
        for (Filier f : student2.getFiliers()) {
            System.out.println("Student 2 Filiere: " + f.getNom());
        }

        // Retrieve and print Addresses
        System.out.println("Adresse 1 Student: " + adresse1.getStudent().getName());
        System.out.println("Adresse 2 Student: " + adresse2.getStudent().getName());
    }
}
