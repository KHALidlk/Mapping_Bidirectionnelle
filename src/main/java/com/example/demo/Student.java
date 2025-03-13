package com.example.demo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
@RequestScoped
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    @Column(nullable=false)
    private String name;
    private String email;
    @OneToOne()
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;
    @OneToMany
    @JoinColumn(name="student_id")
    private List<Cours> cours=new ArrayList<>();
    @ManyToMany
    @JoinTable(name="student_Filiers",joinColumns=@JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="filier_id"))
    private List<Filier> filiers=new ArrayList<>();

    public List<Filier> getFiliers() {
        return filiers;
    }

    public void setFiliers(List<Filier> filiers) {
        this.filiers = filiers;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public Student() {
    }


    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
