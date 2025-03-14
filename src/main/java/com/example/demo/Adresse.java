package com.example.demo;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="adresse")
@RequestScoped
public class Adresse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int adresse_id;
    private String state;
    private String street;
    private String city;
   @OneToOne(mappedBy = "adresse",cascade = CascadeType.ALL)
    private Student student;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(int adresse_id) {
        this.adresse_id = adresse_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Adresse() {
    }


}
