package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name="cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cours_id;
    @Column(nullable=false)
    private String nom;
     @ManyToOne(mappedBy = "cours")
     @JoinColumn(name="student_id")
     private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Cours(){}
    public int getCours_id() {
        return cours_id;
    }

    public void setCours_id(int cours_id) {
        this.cours_id = cours_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
