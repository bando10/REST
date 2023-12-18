package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Agence {
    //attributs
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String login;
    private String password;
    private double remise;

    //methodes
    public Agence() {
    }

    public Agence(String nom, String login, String password, double remise) {
        this.nom = nom;
        this.login = login;
        this.password = password;
        this.remise = remise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", remise=" + remise +
                '}';
    }
}

